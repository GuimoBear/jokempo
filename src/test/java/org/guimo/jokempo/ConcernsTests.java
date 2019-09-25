package org.guimo.jokempo;

import org.guimo.jokempo.concerns.*;
import org.guimo.jokempo.entities.AddictedPlayer;
import org.guimo.jokempo.entities.Player;
import org.guimo.jokempo.entities.RandomPlayer;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConcernsTests {
    private static final Player player1 = new AddictedPlayer("Player one", MoveEnum.Paper);
    private static final Player player2 = new RandomPlayer("Player two");

    @Test
    public void objectConcerns_isNull_with_null_bbject() {
        assertTrue(ObjectConcerns.isNull(null), "The result should be true");
    }

    @Test
    public void objectConcerns_isNull_with_not_null_bbject() {
        assertFalse(ObjectConcerns.isNull(""), "The result should be false");
    }

    @Test
    public void numberConcerns_isLargerThanZero_with_less_than_zero_integer() {
        assertFalse(NumberConcerns.isGreaterThanZero(-1), "The result should be false");
    }

    @Test
    public void numberConcerns_isLargerThanZero_with_zero() {
        assertFalse(NumberConcerns.isGreaterThanZero(0), "The result should be false");
    }

    @Test
    public void numberConcerns_isLargerThanZero_with_greater_than_zero_integer() {
        assertTrue(NumberConcerns.isGreaterThanZero(1), "The result should be true");
    }

    @Test
    public void stringConcerns_IsEmpty_with_null_string() {
        assertTrue(StringConcerns.isEmpty(null), "The result should be true");
    }

    @Test
    public void stringConcerns_IsEmpty_with_empty_string() {
        assertTrue(StringConcerns.isEmpty(""), "The result should be true");
    }

    @Test
    public void stringConcerns_IsEmpty_with_not_null_and_not_empty_string() {
        assertFalse(StringConcerns.isEmpty("Guilherme"), "The result should be false");
    }

    @Test
    public void collectionConcerns_IsEmpty_with_null_collection() {
        assertTrue(CollectionConcerns.isEmpty(null), "The result should be true");
    }

    @Test
    public void collectionConcerns_IsEmpty_with_empty_collection() {
        assertTrue(CollectionConcerns.isEmpty(new ArrayList()), "The result should be true");
    }

    @Test
    public void collectionConcerns_IsEmpty_with_not_null_and_not_empty_collection() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Guilherme");
        assertFalse(CollectionConcerns.isEmpty(list) , "The result should be false");
    }

    @Test
    public void playerConcerns_ValidatePlayers_with_invalid_player1() {
        assertThrows(IllegalArgumentException.class, () -> PlayerConcerns.validatePlayers(null, player2), "a player validation should raise an IllegalArgumentException");
    }

    @Test
    public void playerConcerns_ValidatePlayers_with_invalid_player2() {
        assertThrows(IllegalArgumentException.class, () -> PlayerConcerns.validatePlayers(player1, null), "a player validation should raise an IllegalArgumentException");
    }

    @Test
    public void playerConcerns_ValidatePlayers_with_invalid_player1_and_player2() {
        assertThrows(IllegalArgumentException.class, () -> PlayerConcerns.validatePlayers(null, null), "a player validation should raise an IllegalArgumentException");
    }

    @Test
    public void playerConcerns_ValidatePlayers_with_valid_players() {
        assertDoesNotThrow(() -> PlayerConcerns.validatePlayers(player1, player2), "a player validation should not raise any exception");
    }

    @Test
    public void playerConcerns_AreEquals_with_null_player1_and_valid_player2() {
        assertFalse(PlayerConcerns.areEquals(null, player2), "players should not be equals");
    }

    @Test
    public void playerConcerns_AreEquals_with_valid_player1_and_null_player2() {
        assertFalse(PlayerConcerns.areEquals(player1, null), "players should not be equals");
    }

    @Test
    public void playerConcerns_AreEquals_with_null_players() {
        assertTrue(PlayerConcerns.areEquals(null, null), "players should be equals");
    }

    @Test
    public void playerConcerns_AreEquals_with_valid_player1_and_player2() {
        assertFalse(PlayerConcerns.areEquals(player1, player2), "players should not be equals");
    }

    @Test
    public void playerConcerns_AreEquals_with_same_player1_and_player2() {
        assertTrue(PlayerConcerns.areEquals(player1, player1), "players should be equals");
    }

    @Test
    public void moveEnumConcerns_AreEquals_with_null_move1_and_valid_move2() {
        assertFalse(MoveEnumConcerns.areEquals(null, MoveEnum.Paper), "moves should not be equals");
    }

    @Test
    public void moveEnumConcerns_AreEquals_with_valid_move1_and_null_move2() {
        assertFalse(MoveEnumConcerns.areEquals(MoveEnum.Paper, null), "moves should not be equals");
    }

    @Test
    public void moveEnumConcerns_AreEquals_with_null_moves() {
        assertTrue(MoveEnumConcerns.areEquals(null, null), "moves should be equals");
    }

    @Test
    public void moveEnumConcerns_AreEquals_with_valid_move1_and_move2() {
        assertFalse(MoveEnumConcerns.areEquals(MoveEnum.Rock, MoveEnum.Scissors), "moves should not be equals");
    }

    @Test
    public void moveEnumConcerns_AreEquals_with_same_move1_and_move2() {
        assertTrue(MoveEnumConcerns.areEquals(MoveEnum.Rock, MoveEnum.Rock), "moves should be equals");
    }
}
