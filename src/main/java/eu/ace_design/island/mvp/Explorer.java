package eu.ace_design.island.mvp;

import eu.ace_design.island.bot.IExplorerRaid;

public class Explorer implements IExplorerRaid {
    char heading;
    JSONFactory jfk;
    
    @Override
    public void initialize(String string) {
       jfk = new JSONFactory();
       Objectif o = jfk.build_obj(string);
      
       
        
        
                
        
                        
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