/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.exceptions;

/**
 * Classe Regroupant toutes les exeptions de l'exporer
 * @author user
 */
public abstract class ExplorerExeption extends RuntimeException {
  public ExplorerExeption(String message) {
    super(message);
  }
}
