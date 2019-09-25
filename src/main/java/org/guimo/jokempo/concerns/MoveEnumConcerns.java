package org.guimo.jokempo.concerns;

import org.guimo.jokempo.valueobjects.MoveEnum;

public class MoveEnumConcerns {
    public static boolean areEquals(MoveEnum left, MoveEnum right) {
        if(ObjectConcerns.isNull(left) && ObjectConcerns.isNull(right)) {
            return true;
        } else if(ObjectConcerns.isNull(left) || ObjectConcerns.isNull(right)) {
            return false;
        }
        return left.getValue().equals(right.getValue());
    }
}
