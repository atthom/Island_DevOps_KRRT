package eu.ace_design.island.mvp;

import eu.ace_design.island.bot.IExplorerRaid;
import eu.ace_design.island.mvp.strategy.Strategy;

public class Explorer implements IExplorerRaid {
    private char heading;
    private JSONFactory jfk;
    private Strategy strat;
    
    @Override
    public void initialize(String string) {
       jfk = new JSONFactory();
       Objectif o = jfk.build_obj(string);
       Prototype p = new Prototype(o);
               
    }

    @Override
    public String takeDecision() {
        return "{ \"action\": \"stop\" }";
    }

    @Override
    public void acknowledgeResults(String string) {     
        System.out.println(string);
    }
    
}