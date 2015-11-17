/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.resources;

/**
 *
 * @author user
 */
public class ExtractedResource {

    private int nb;
    private String name;

    public ExtractedResource(int nb, String name) {
        this.nb = nb;
        this.name = name;
    }

    public int getNb() {
        return nb;
    }

    public void enleve(int nb) {
        if (this.nb >= nb) {
            this.nb = this.nb - nb;
        } else {
            this.nb = 0;
        }
    }

    @Override
    public String toString() {
        return "Ressource{" + "nb=" + nb + ", name=" + name + '}';
    }

    public String getName() {
        return name;
    }

}