package eu.ace_design.island.mvp.actions;

/**
 * Created by Lo�c on 11/15/2015.
 */
public class Fly extends AbstractAction {

    private String head; // EAST, WEST, NORTH, EAST

    public Fly(int cost){
        super();
        this.setActionName("Fly");
        this.setActionCost(cost);
        // TODO influence factor maybe
    }

    private String getHead(){
        return this.head;
    }


    public void actionExecute(){
        // TODO - le drone avance de 3 case

        /*
            We need to know the position of the drone
         */
        switch (this.getHead()){
            case "EAST":
                // The drone just go to the east, so we have to reduce his Xpos
                break;
            case "WEST":
                //
                break;
        }
    }
}
