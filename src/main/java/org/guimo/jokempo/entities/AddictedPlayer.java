package org.guimo.jokempo.entities;

import org.guimo.jokempo.concerns.ObjectConcerns;
import org.guimo.jokempo.valueobjects.MoveEnum;

public class AddictedPlayer extends Player {
    private final MoveEnum addictedMove;

    public AddictedPlayer(String name, MoveEnum addictedMove) {
        super(name);
        if (ObjectConcerns.isNull(addictedMove)) {
            throw new IllegalArgumentException("A jogada viciada não pode ser nula");
        }
        this.addictedMove = addictedMove;
    }

    @Override
    public MoveEnum play() {
        return addictedMove;
    }
}
