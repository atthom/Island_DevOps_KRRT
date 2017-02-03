package fr.unice.polytech.qgl.qae;

/**
 * Created by Thom on 03/02/2017.
 */
import org.apache.log4j.Level;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;

/**
 * Reports warnings when empty catch blocks are found.
 */
class CatchProcessor extends AbstractProcessor<CtCatch> {
    public void process(CtCatch element) {
        if (element.getBody().getStatements().size() > 0) {
            getFactory().getEnvironment().report(this, Level.WARN, element, "empty catch clause");
        }
    }
}