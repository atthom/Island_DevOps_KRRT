package eu.ace_design.island.mvp.actions;

/**
 * Created by Lo�c on 11/15/2015.
 *
 * Classe abstraite qui sera la classe mere de toutes les classe particulieres aux commandes!
 */
abstract class AbstractAction {

    private String actionName;
    private int actionCost;
    private int influenceFactor;


    protected void setActionName(String name){
        this.actionName = name;
    }

    protected void setActionCost(int cost){
        this.actionCost = cost;
    }

    protected void setInfluenceFactor(int influence){
        this.influenceFactor = influence;
    }

    abstract void actionExecute();
}
