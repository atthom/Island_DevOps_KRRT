package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.HeadingType;

import java.util.ArrayList;

/**
 * Created by Loïc on 27/12/2015.
 */
public class MissionAssignment {

    private int nb_men;
    private int budget;
    private HeadingType heading;
    private ArrayList<Contract> contracts = new ArrayList<>();

    public MissionAssignment(){}

    public void setNb_men(int aNbOfMen){ this.nb_men = aNbOfMen;}
    public int getNb_men(){ return this.nb_men;}

    public void setBudget(int aBudget){ this.budget = aBudget;}
    public int getBudget(){ return this.budget;}

    public void setHeading(HeadingType theHeading){ this.heading = theHeading;}
    public HeadingType getHeading(){ return this.heading;}

    public ArrayList<Contract> getContracts(){ return this.contracts;}

    public void retrieveActionPoint(int anAmount){ this.budget -= anAmount;}

    public void addContract(Contract aContract){ this.contracts.add(aContract);}

}
