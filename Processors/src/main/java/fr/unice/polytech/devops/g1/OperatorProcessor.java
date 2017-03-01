package fr.unice.polytech.devops.g1;

import org.apache.log4j.Level;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCatch;
import spoon.reflect.declaration.CtElement;

/**
 * Reports warnings when empty catch blocks are found.
 */
public class OperatorProcessor extends AbstractProcessor<CtCatch> {
    public void process(CtCatch element) {
        if (element.getBody().getStatements().size() != 0) {
            getFactory().getEnvironment().report(this, Level.WARN, element, "non empty catch clause");
        }
    }
}