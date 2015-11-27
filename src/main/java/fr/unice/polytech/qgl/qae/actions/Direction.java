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
   
    /**
     *
     * @return la direction opposée
     */
    
    public Direction opposite() {
       switch (this) {
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
   
    /**
     *
     * @param d une direction
     * @return si la direction est alignée ou opposé.
     */
    public boolean is_aligned(Direction d) {
       return this==d | d.opposite()==this;
   }
}
