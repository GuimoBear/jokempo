package org.guimo.jokempo;

import org.guimo.jokempo.entities.AddictedPlayer;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddictedPlayerTests {

    @Test
    public void new_instance_with_invalid_addicted_move() {
        assertThrows(IllegalArgumentException.class, () -> new AddictedPlayer("Guilherme", null), "a addicted Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void new_instance_with_valid_addicted_move() {
        assertDoesNotThrow(() -> new AddictedPlayer("Guilherme", MoveEnum.Paper), "a addicted Player object should be created and not raise an IllegalArgumentException");
    }

    @RepeatedTest(value = 10)
    public void play_ten_times() {
        AddictedPlayer player = new AddictedPlayer("Guilherme", MoveEnum.Paper);
        assertEquals(player.play(), MoveEnum.Paper, "The move should equal " + MoveEnum.Paper.toString());
    }
}
