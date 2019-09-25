package org.guimo.jokempo.concerns;

import java.util.Collection;

public class CollectionConcerns {
    public static boolean isEmpty(Collection collection) {
        return ObjectConcerns.isNull(collection) || collection.isEmpty();
    }
}
