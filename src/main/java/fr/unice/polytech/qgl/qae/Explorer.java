package fr.unice.polytech.qgl.qae;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.Phase1;
import org.json.JSONObject;

public class Explorer implements IExplorerRaid {
   
    private JSONFactory jfk;
    
    private AbstractPhase phase;
    private Objectif o; 
    
    
    @Override
    public void initialize(String string) {
       jfk = new JSONFactory();
       o = jfk.build_obj(string);

       //strat = new FlyingStrategy(jfk.build_heading(string));

       phase = new Phase1(this, new Coordinates(0, 0), jfk.build_heading(string).getValueParameter());

    }

    public void setPhase(AbstractPhase phase) {
        this.phase = phase;
    }
    
    
    
    private void manage_cost(Objectif o, JSONObject js) {
        o.enleve_PA(js.getInt("cost"));
    }
    
    
    @Override
    public String takeDecision()
    {
        return phase.act().toJSON().toString();
    }

    @Override
    public void acknowledgeResults(String string) {
        JSONObject js = new JSONObject(string);
        manage_cost(o, js);
        phase.acknowledge(js);
    }
    
}