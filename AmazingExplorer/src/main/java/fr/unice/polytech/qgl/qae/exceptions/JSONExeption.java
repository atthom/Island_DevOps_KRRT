/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.exceptions;

/**
 * Gere les exeptions JSON
 * @author user
 */
public class JSONExeption extends ExplorerExeption {
    
  public JSONExeption(String object) {
    super("L'objet " + object + " n'a pas pu être créer !");
  }
}
