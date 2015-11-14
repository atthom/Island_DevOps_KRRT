package eu.ace_design.island.mvp;

import eu.ace_design.island.bot.IExplorerRaid;
import java.util.ArrayList;
import org.json.JSONObject;

public class Explorer implements IExplorerRaid {
    char heading;
    
    
    @Override
    public void initialize(String string) {
        JSONObject obj = new JSONObject(string);
        
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