package org.guimo.jokempo.entities;

import org.guimo.jokempo.utils.IntegerUtils;
import org.guimo.jokempo.valueobjects.MoveEnum;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public MoveEnum play() {
        switch (IntegerUtils.Random() % 3) {
            case 0:
                return MoveEnum.Rock;
            case 1:
                return MoveEnum.Paper;
            default:
                return MoveEnum.Scissors;
        }
    }
}
