package fr.unice.polytech.qgl.qae;

/**
 *
 * @author Thomas M
 */
public class Prototype {

  private long budgetMAx;
  private boolean stop = false;
  private Objectif o;

  public Prototype(Objectif o) {
      this.o = o;
  }

  public void start() {


      if (stop)
      {
          // A définir
          //return new Action("stop");
      }

      if(o.getBudget() < 50){
          //return new Action("stop");
      }


  }

}
