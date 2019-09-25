package org.guimo.jokempo;

import org.guimo.jokempo.entities.AddictedPlayer;
import org.guimo.jokempo.entities.Player;
import org.guimo.jokempo.entities.RandomPlayer;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.guimo.jokempo.valueobjects.RoundResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoundResultTests {

    private static final Player player1 = new AddictedPlayer("Player one", MoveEnum.Paper);
    private static final Player player2 = new RandomPlayer("Player two");

    private static final MoveEnum move1 = MoveEnum.Paper;
    private static final MoveEnum move2 = MoveEnum.Scissors;

    @Test
    public void draw_result_with_valid_move() {
        assertDoesNotThrow(() -> RoundResult.DrawResult(MoveEnum.Rock), "a round result should be created without exceptions");

    }

    @Test
    public void draw_result_with_invalid_move() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.DrawResult(null), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }


    @Test
    public void winner_result_with_invalid_winner_player() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(null, move2, player1, move1), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_invalid_winner_player_and_winner_move() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(null, null, player1, move1), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_invalid_loser_player() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(player2, move2, null, move1), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_invalid_loser_player_and_loser_move() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(player2, move2, null, null), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_invalid_winner_player_winner_move_loser_player_and_loser_move() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(null, null, null, null), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_same_player_in_winner_and_loser() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(player1, move1, player1, move2), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_same_move_in_winner_and_loser() {
        assertThrows(IllegalArgumentException.class, () -> RoundResult.WinnerResult(player2, move2, player1, move2), "a round result Player object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void winner_result_with_all_valid_parameters() {
        assertDoesNotThrow(() -> RoundResult.WinnerResult(player2, move2, player1, move1), "a round result should be created without exceptions");
    }
}
