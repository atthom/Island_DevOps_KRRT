package eu.ace_design.island.mvp;

import eu.ace_design.island.bot.IExplorerRaid;

public class Explorer implements IExplorerRaid {
    public void initialize(String string) {
        
    }

    public String takeDecision() {
        return "{ \"action\": \"stop\" }";
    }

    public void acknowledgeResults(String string) {     
        System.out.println(string);
    }
    
}