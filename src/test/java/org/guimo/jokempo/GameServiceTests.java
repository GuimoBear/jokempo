package org.guimo.jokempo;

import org.guimo.jokempo.concerns.MoveEnumConcerns;
import org.guimo.jokempo.entities.AddictedPlayer;
import org.guimo.jokempo.entities.Player;
import org.guimo.jokempo.entities.RandomPlayer;
import org.guimo.jokempo.services.GameService;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTests {

    private static final Player player1 = new AddictedPlayer("Player one", MoveEnum.Paper);
    private static final Player player2 = new RandomPlayer("Player two");

    @Test
    public void game_service_with_invalid_player1() {
        assertThrows(IllegalArgumentException.class, () -> new GameService(null, player2), "a game service object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_service_with_invalid_player2() {
        assertThrows(IllegalArgumentException.class, () -> new GameService(player1, null), "a game service object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_service_with_invalid_player1_and_player2() {
        assertThrows(IllegalArgumentException.class, () -> new GameService(null, null), "a game service object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_service_with_same_player() {
        assertThrows(IllegalArgumentException.class, () -> new GameService(player1, player1), "a game service object should not be created and should raise an IllegalArgumentException");
    }

    @Test
    public void game_service_validate_draw_result() {
        GameService service = new GameService(player1, player2);
        assertTrue(service.isDraw(MoveEnum.Paper, MoveEnum.Paper), "the players play Paper the result should be a draw");
    }

    @ParameterizedTest(name = "{index} => move1={0}, move2={1}, winner move={2}")
    @MethodSource("movesProvider")
    public void game_service_validate_move_winner(MoveEnum move1, MoveEnum move2, MoveEnum expected) {
        GameService service = new GameService(player1, player2);        ;
        assertTrue(MoveEnumConcerns.areEquals(service.getWinnerMove(move1, move2), expected), "the moves " + move1.toString() + " and " + move2.toString() + " result in " + expected.toString() + " as winner");
    }

    private static Stream<Arguments> movesProvider() {
        return Stream.of(
            Arguments.of(MoveEnum.Rock, MoveEnum.Paper, MoveEnum.Paper),
            Arguments.of(MoveEnum.Paper, MoveEnum.Scissors, MoveEnum.Scissors),
            Arguments.of(MoveEnum.Scissors, MoveEnum.Rock, MoveEnum.Rock)
        );
    }

    @Test
    public void game_service_single_play() {
        assertDoesNotThrow(() -> new GameService(player1, player2).play(), "a game service should be created and run play method without exceptions");
    }

    @Test
    public void game_service_play_ten_times() {
        assertDoesNotThrow(() -> new GameService(player1, player2).play(10), "a game service should be created and run play method with 10 rounds without exceptions");
    }
}
