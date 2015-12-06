package fr.unice.polytech.qgl.qae;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.qgl.qae.strategy.FlyingStrategy;
import fr.unice.polytech.qgl.qae.strategy.Phase1;
import fr.unice.polytech.qgl.qae.strategy.Phase2;
import fr.unice.polytech.qgl.qae.strategy.Strategy;
import org.json.JSONObject;

public class Explorer implements IExplorerRaid {
   
    private JSONFactory jfk;
    private Strategy strat;
    private Objectif o; 
    
    
    @Override
    public void initialize(String string) {
       jfk = new JSONFactory();
       o = jfk.build_obj(string);

       //strat = new FlyingStrategy(jfk.build_heading(string));

        strat = new FlyingStrategy(jfk.build_heading(string));


    }
    
    private void manage_cost(Objectif o, JSONObject js) {
        o.enleve_PA(js.getInt("cost"));
    }
    
    
    @Override
    public String takeDecision()
    {
        return strat.execute();
    }

    @Override
    public void acknowledgeResults(String string) {
        JSONObject js = new JSONObject(string);
        manage_cost(o, js);
        System.out.println(string);
        strat.acknowledge(js);
    }
    
}