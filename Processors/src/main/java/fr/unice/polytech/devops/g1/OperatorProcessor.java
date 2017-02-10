package fr.unice.polytech.devops.g1;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;

/**
 * Reports warnings when empty catch blocks are found.
 */
public class OperatorProcessor extends AbstractProcessor<CtElement> {
    public void process(CtElement element) {
        if(element instanceof CtBinaryOperator){
            ((CtBinaryOperator) element).setKind(BinaryOperatorKind.MINUS);
        }
    }
}