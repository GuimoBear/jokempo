package org.guimo.jokempo.entities;

import org.guimo.jokempo.concerns.ObjectConcerns;
import org.guimo.jokempo.concerns.StringConcerns;
import org.guimo.jokempo.valueobjects.MoveEnum;

public abstract class Player {
    private final String name;

    public Player(String name) throws IllegalArgumentException {
        if(StringConcerns.isEmpty(name))
            throw new IllegalArgumentException("O nome deve ser preenchido");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract MoveEnum play();

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(ObjectConcerns.isNull(obj))
            return false;
        if(obj instanceof Player) {
            return obj.hashCode() == hashCode();
        }
        return false;
    }
}
