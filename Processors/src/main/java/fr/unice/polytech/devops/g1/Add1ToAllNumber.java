package fr.unice.polytech.devops.g1;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import javax.lang.model.type.TypeKind;

/**
 * Created by Thom on 17/02/2017.
 */

public class Add1ToAllNumber extends AbstractProcessor<CtLiteral> {
    public void process(CtLiteral element) {
        Object value = element.getValue();
        if(value instanceof Integer) {
            Integer val  = (Integer) value;
            element.setValue(val+1);
        }

    }
}