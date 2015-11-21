/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

/**
 *
 * @author user
 */
public enum Direction {
   E,
   W,
   S,
   N;
   
   public Direction opposite(Direction d) {
       switch (d) {
           case E:
               return W;
           case W:
               return E;
           case S:
               return N;
           default:
               return S;
       }
   }
   
   public boolean is_sameoropposite(Direction d) {
       return this==d | opposite(d)==this;
   }
}
