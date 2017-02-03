package fr.unice.polytech.qgl.qae.exceptions;

/**
 * Created by Loïc on 08/12/2015.
 */
public class InvalidNumberException extends Exception {

    public InvalidNumberException(int n){
        System.out.println("Error: " + n + " is an invalid value!");
    }
}
