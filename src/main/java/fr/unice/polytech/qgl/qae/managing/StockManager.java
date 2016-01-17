package fr.unice.polytech.qgl.qae.managing;

import fr.unice.polytech.qgl.qae.exceptions.NotEnoughResourceException;
import fr.unice.polytech.qgl.qae.resources.ResourceType;

import java.util.HashMap;

/**
 * Created by Loïc on 30/12/2015.
 */
public class StockManager {

    private HashMap<ResourceType, Integer> stocks = new HashMap<>();

    public StockManager(){}

    /**
     * This method add a value of a specified resource from stock.
     * @param aResourceName : name of resource to increment
     * @param incrementValue
     * @return the amount of resource after adding the decrement value
     * TODO - Check if the increment value is a positive value
     */
    public int addToStock(String aResourceName, int incrementValue){
        // We get the resource type from the resource name.
        ResourceType resource = ResourceType.valueOf(aResourceName);
        int stockValue = incrementValue;
        // If resource is already in stock, then...
        if (stocks.containsKey(resource)){
            // we add the increment value to the previous stock value.
            stockValue += stocks.get(resource);
        }
        stocks.put(resource, stockValue);
        return stockValue;
    }

    /**
     * This method remove a value of a specified resource from stock.
     * @param aResourceName : name of resource to decrement
     * @param decrementValue
     * @return the amount of resource after removing the decrement value
     */
    public int removeFromStock(String aResourceName, int decrementValue) throws NotEnoughResourceException{
        ResourceType resource = ResourceType.valueOf(aResourceName);
        int stockValue = 0;
        if (stocks.containsKey(resource)){
            stockValue = stocks.get(resource);
        }
        if (decrementValue > stockValue){
            throw new NotEnoughResourceException();
        }
        stockValue -= decrementValue;
        stocks.put(resource, stockValue);
        return stockValue;
    }

    /**
     * This method get the value of a specified resource if it is in the stock.
     * @param resourceName : name of resource
     * @return the amount of the specified resource in the stock.
     */
    public int getStockValue(String resourceName){
        ResourceType resource = ResourceType.valueOf(resourceName);
        if (stocks.containsKey(resource)) return stocks.get(resource);
        return 0;
    }

}
