package fr.unice.polytech.qgl.qae;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.FStrategy;
import fr.unice.polytech.qgl.qae.strategy.Phase1;
import org.json.JSONObject;

public class Explorer implements IExplorerRaid {
   
    private JSONFactory jfk;
    
    private Objectif o; 
    private AbstractStrategy strat;
    
    @Override
    public void initialize(String string) {
       jfk = new JSONFactory();
       o = jfk.build_obj(string);

       strat = new FStrategy(jfk.build_heading(string).getValueParameter()); 

    }

    private void manage_cost(Objectif o, JSONObject js) {
        o.enleve_PA(js.getInt("cost"));
    }
    
    
    @Override
    public String takeDecision()
    {
        return strat.execute().toJSON().toString();
    }

    @Override
    public void acknowledgeResults(String string) {
        JSONObject js = new JSONObject(string);
        manage_cost(o, js);
        strat.acknowledge(js);
    }
    
}
