package fr.unice.polytech.qgl.qae.actions;

/**
 * Created by Lo�c on 11/15/2015.
 *
 * Classe abstraite qui sera la classe mere de toutes les classe particulieres aux commandes
 */
abstract class AbstractAction {

    private int actionCost;

    public AbstractAction(){
    }
    
    protected void setActionCost(int cost){
        this.actionCost = cost;
    }
}
