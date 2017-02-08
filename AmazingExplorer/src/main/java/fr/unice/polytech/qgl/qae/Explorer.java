package fr.unice.polytech.qgl.qae;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.qgl.qae.resources.MissionAssignment;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.tools.JSONFactory;
import org.json.JSONObject;

public class Explorer implements IExplorerRaid {

    private JSONFactory jfk;
    //private JSONHelper jsh;


    private MissionAssignment mission;
    private AbstractStrategy strat;

    @Override
    public void initialize(String string) {
        try {
            //jfk = new JSONFactory();
            // mission = jfk.build_obj(string);
            // strat = new FlyingStrategy(jfk.build_heading(string).getValueParameter(),o);
            jfk = new JSONFactory();
            mission = jfk.getMissionAssignmentFromJSONString(string);
            strat = new FlyingStrategy(mission.getHeading(), mission);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void manage_cost(MissionAssignment mission, JSONObject js) {
        mission.retrieveActionPoint(js.getInt("cost"));
    }


    @Override
    public String takeDecision() {
        return strat.execute().toJSON().toString();
    }

    @Override
    public void acknowledgeResults(String string) {
        JSONObject js = new JSONObject(string);
        manage_cost(mission, js);
        strat.acknowledge(js);
    }

}
