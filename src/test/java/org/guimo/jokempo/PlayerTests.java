package org.guimo.jokempo;

import org.guimo.jokempo.entities.RandomPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    @Test()
    public void create_valid_player() {
        assertDoesNotThrow(() -> new RandomPlayer("Guilherme"), "a Player object should be created without exceptions");
    }

    @Test()
    public void create_invalid_player() {
        assertThrows(IllegalArgumentException.class, () -> new RandomPlayer(""), "a Player object should not be created and should raise an IllegalArgumentException");
    }

}
