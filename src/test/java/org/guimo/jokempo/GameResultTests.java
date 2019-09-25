package org.guimo.jokempo;

import org.guimo.jokempo.entities.AddictedPlayer;
import org.guimo.jokempo.entities.Player;
import org.guimo.jokempo.entities.RandomPlayer;
import org.guimo.jokempo.valueobjects.GameResult;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.guimo.jokempo.valueobjects.RoundResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class GameResultTests {
    private static final Player player1 = new AddictedPlayer("Player one", MoveEnum.Paper);
    private static final Player player2 = new RandomPlayer("Player two");

    private static final Collection<RoundResult> emptyResults = new ArrayList<>();
    private static final Collection<RoundResult> drawResults;
    private static final Collection<RoundResult> player1WinnerResults;
    private static final Collection<RoundResult> player2WinnerResults ;

    static {
        drawResults = createTieCollection();
        player1WinnerResults = createPlayer1WinnerResults();
        player2WinnerResults = createPlayer2WinnerResults();
    }

    private static Collection<RoundResult> createTieCollection() {
        Collection<RoundResult> results = new ArrayList<>();
        results.add(RoundResult.DrawResult(MoveEnum.Rock.Paper));
        results.add(RoundResult.WinnerResult(player1, MoveEnum.Paper, player2, MoveEnum.Rock));
        results.add(RoundResult.WinnerResult(player2, MoveEnum.Scissors, player1, MoveEnum.Paper));
        results.add(RoundResult.DrawResult(MoveEnum.Rock.Paper));
        return results;
    }

    private static Collection<RoundResult> createPlayer1WinnerResults() {
        Collection<RoundResult> results = new ArrayList<>();
        results.add(RoundResult.WinnerResult(player1, MoveEnum.Paper, player2, MoveEnum.Rock));
        results.add(RoundResult.WinnerResult(player2, MoveEnum.Scissors, player1, MoveEnum.Paper));
        results.add(RoundResult.WinnerResult(player1, MoveEnum.Paper, player2, MoveEnum.Rock));
        results.add(RoundResult.DrawResult(MoveEnum.Rock.Paper));
        return results;
    }

    private static Collection<RoundResult> createPlayer2WinnerResults() {
        Collection<RoundResult> results = new ArrayList<>();
        results.add(RoundResult.WinnerResult(player2, MoveEnum.Scissors, player1, MoveEnum.Paper));
        results.add(RoundResult.WinnerResult(player1, MoveEnum.Paper, player2, MoveEnum.Scissors));
        results.add(RoundResult.WinnerResult(player2, MoveEnum.Scissors, player1, MoveEnum.Paper));
        results.add(RoundResult.DrawResult(MoveEnum.Rock.Paper));
        return results;
    }

    @Test
    public void game_result_with_invalid_player1() {
        assertThrows(IllegalArgumentException.class, () -> new GameResult(null, player2, drawResults), "a game result object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_result_with_invalid_player2() {
        assertThrows(IllegalArgumentException.class, () -> new GameResult(player1,null, drawResults), "a game result object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_result_with_null_results() {
        assertThrows(IllegalArgumentException.class, () -> new GameResult(player1, player2, null), "a game result object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_result_with_empty_results() {
        assertThrows(IllegalArgumentException.class, () -> new GameResult(player1, player2, emptyResults), "a game result object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_result_with_tie_results() {
        GameResult result = new GameResult(player1, player2, drawResults);
        assertFalse(result.hasWinner(), "The result should be false");
    }

    @Test
    public void game_result_with_player1_winner() {
        GameResult result = new GameResult(player1, player2, player1WinnerResults);
        assertEquals(player1, result.getWinner(), "The player 1 and tne game result winner should be equals");
    }

    @Test
    public void game_result_with_player2_winner() {
        GameResult result = new GameResult(player1, player2, player2WinnerResults);
        assertEquals(player2, result.getWinner(), "The player 2 and tne game result winner should be equals");
    }
}
