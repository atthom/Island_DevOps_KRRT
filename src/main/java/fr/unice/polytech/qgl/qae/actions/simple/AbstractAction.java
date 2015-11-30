package fr.unice.polytech.qgl.qae.actions.simple;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Created by Lo�c on 11/15/2015.
 *
 * Classe abstraite qui sera la classe mere de toutes les classe particulieres aux commandes
 */
public abstract class AbstractAction {

    private int moy_actionCost;
    private int nb_set;
    private final String name;

    /**
     * Permet de crée facilement une action sans parametre sous format JSON
     * @param name nom de l'action (action json)
     */
    public AbstractAction(String name){
        this.name = name;
        moy_actionCost=0;
        nb_set=0;
    }

    /**
     *
     * @return le nom de l'action
     */
    public String getName() {
        return name;
    }
    
    /**
     * Permet de calculer le cout moyen de l'action effectuée
     * @param cost cout de l'action effectuée
     */
    public void setActionCost(int cost){
        nb_set++;
        this.moy_actionCost = (this.moy_actionCost + cost)/nb_set;
    }

    /**
     *
     * @return le cout moyen de l'action
     */
    public int getActionCost() {
        return this.moy_actionCost;
    }
    
    /**
     *
     * @return un object JSON correspondant à l'action
     */
    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        o.put("action", name);
        return o;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final AbstractAction other = (AbstractAction) obj;
//        if (this.moy_actionCost != other.moy_actionCost) {
//            return false;
//        }
//        if (this.nb_set != other.nb_set) {
//            return false;
//        }
//        return Objects.equals(this.name, other.name);
//    }
    
}
