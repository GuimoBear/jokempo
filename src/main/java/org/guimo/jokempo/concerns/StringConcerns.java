package org.guimo.jokempo.concerns;

public class StringConcerns {
    public static boolean isEmpty(String value) {
        return ObjectConcerns.isNull(value) || value.equals("");
    }
}
