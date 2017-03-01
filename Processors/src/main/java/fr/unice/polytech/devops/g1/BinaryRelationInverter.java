package fr.unice.polytech.devops.g1;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtExpression;


/**
 * Created by Thom on 17/02/2017.
 */
public class BinaryRelationInverter extends AbstractProcessor<CtBinaryOperator> {
    public void process(CtBinaryOperator element) {
        CtExpression left = element.getLeftHandOperand();
        element.setLeftHandOperand(element.getRightHandOperand());
        element.setRightHandOperand(left);

    }
}
