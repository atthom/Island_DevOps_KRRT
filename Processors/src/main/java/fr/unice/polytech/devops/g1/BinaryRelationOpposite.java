package fr.unice.polytech.devops.g1;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;


/**
 * Created by Thom on 17/02/2017.
 */
public class BinaryRelationOpposite extends AbstractProcessor<CtBinaryOperator> {

    public void process(CtBinaryOperator element) {
        BinaryOperatorKind kind = element.getKind();
        switch (kind) {
            case AND:
                element.setKind(BinaryOperatorKind.OR);
                break;
            case OR:
                element.setKind(BinaryOperatorKind.AND);
                break;
            case EQ:
                element.setKind(BinaryOperatorKind.NE);
                break;
            case NE:
                element.setKind(BinaryOperatorKind.EQ);
                break;
            case GE:
                element.setKind(BinaryOperatorKind.LE);
                break;
            case LE:
                element.setKind(BinaryOperatorKind.GE);
                break;
            case GT:
                element.setKind(BinaryOperatorKind.LT);
                break;
            case LT:
                element.setKind(BinaryOperatorKind.GT);
                break;
            case MINUS:
                element.setKind(BinaryOperatorKind.PLUS);
                break;
            case MUL:
                element.setKind(BinaryOperatorKind.DIV);
                break;
            case DIV:
                element.setKind(BinaryOperatorKind.MUL);
                break;
        }
    }
}
