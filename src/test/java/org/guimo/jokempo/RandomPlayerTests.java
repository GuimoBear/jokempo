package org.guimo.jokempo;

import org.guimo.jokempo.entities.RandomPlayer;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RandomPlayerTests {

    @RepeatedTest(value = 10)
    public void play_ten_times() {
        assertDoesNotThrow(() -> {
            RandomPlayer player = new RandomPlayer("Guilherme");
            player.play();
        }, "a Player play should happening without exceptions");
    }

}
