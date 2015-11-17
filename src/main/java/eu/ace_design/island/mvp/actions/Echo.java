package eu.ace_design.island.mvp.actions;

/**
 * Created by Lo�c on 11/15/2015.
 */
public class Echo extends AbstractAction {


    public Echo(int cost){
        super();
        this.setActionName("Fly");
        this.setActionCost(cost);
        // TODO influence factor maybe
    }


    public void actionExecute(){
        // TODO
    }
}
