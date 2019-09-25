package org.guimo.jokempo.services;

import org.guimo.jokempo.concerns.MoveEnumConcerns;
import org.guimo.jokempo.concerns.NumberConcerns;
import org.guimo.jokempo.concerns.ObjectConcerns;
import org.guimo.jokempo.concerns.PlayerConcerns;
import org.guimo.jokempo.entities.Player;
import org.guimo.jokempo.valueobjects.GameResult;
import org.guimo.jokempo.valueobjects.MoveEnum;
import org.guimo.jokempo.valueobjects.RoundResult;

import java.util.ArrayList;
import java.util.Collection;

public class GameService {

    private final Player player1;
    private final Player player2;

    public GameService(Player player1, Player player2) throws IllegalArgumentException {
        PlayerConcerns.validatePlayers(player1, player2);
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isDraw(MoveEnum move1, MoveEnum move2) throws IllegalArgumentException {
        if(ObjectConcerns.isNull(move1) || ObjectConcerns.isNull(move2)) {
            throw new IllegalArgumentException("As jogadas não podem ser vazias");
        }
        return MoveEnumConcerns.areEquals(move1, move2);
    }

    public MoveEnum getWinnerMove(MoveEnum move1, MoveEnum move2) {
        if(isDraw(move1, move2)) {
            return null;
        }
        if((MoveEnumConcerns.areEquals(move1, MoveEnum.Paper) && MoveEnumConcerns.areEquals(move2, MoveEnum.Rock)) ||
           (MoveEnumConcerns.areEquals(move1, MoveEnum.Rock) && MoveEnumConcerns.areEquals(move2, MoveEnum.Scissors)) ||
           (MoveEnumConcerns.areEquals(move1, MoveEnum.Scissors) && MoveEnumConcerns.areEquals(move2, MoveEnum.Paper))) {
            return move1;
        }
        return move2;
    }

    public RoundResult play() {
        MoveEnum move1 = player1.play();
        MoveEnum move2 = player2.play();
        if (isDraw(move1, move2)) {
            return RoundResult.DrawResult(move1);
        }else if(MoveEnumConcerns.areEquals(getWinnerMove(move1, move2), move1)) {
            return RoundResult.WinnerResult(player1, move1, player2, move2);
        }
        return RoundResult.WinnerResult(player2, move2, player1, move1);
    }

    public GameResult play(int rounds) throws IllegalArgumentException {
        if(!NumberConcerns.isGreaterThanZero(rounds)) {
            throw new IllegalArgumentException("O numero de rodadas dentro de um jogo deve ser maior que zero");
        }
        Collection<RoundResult> results = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            results.add(play());
        }
        return new GameResult(player1, player2, results);
    }
}
