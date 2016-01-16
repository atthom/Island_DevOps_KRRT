package fr.unice.polytech.qgl.qae.exceptions;

/**
 * Created by Loïc on 30/12/2015.
 */
public class InvalidResourceAmountException extends Exception {
    public InvalidResourceAmountException(){
        super("The resource amount must be a multiple of the unitary amount.");
    }
}
