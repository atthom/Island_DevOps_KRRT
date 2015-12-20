package fr.unice.polytech.qgl.qae.actions.withparams;

/**
 * Created by Lo�c on 11/15/2015.
 */
public class Echo extends ActionWithParameters {

    /**
     * Classe Action Echo
     * @param d parametre de l'action
     */
    public Echo(Direction d){
      super(new Parameter("direction", d), "echo");
    } 

    @Override
    public Object getValueParameter() {
       return (Direction) parameters.get(0).getValeur();
    }
    
}