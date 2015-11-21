package fr.unice.polytech.qgl.qae.actions;

/**
 * Created by Lo�c on 11/15/2015.
 */
public class Echo extends ActionWithParameters {

    public Echo(Direction d){
      super(new Parameter("direction", d), "echo");
    } 

    @Override
    public Object getValueParameter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}