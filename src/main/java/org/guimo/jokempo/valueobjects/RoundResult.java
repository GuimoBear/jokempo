package org.guimo.jokempo.valueobjects;

import org.guimo.jokempo.concerns.MoveEnumConcerns;
import org.guimo.jokempo.concerns.ObjectConcerns;
import org.guimo.jokempo.concerns.PlayerConcerns;
import org.guimo.jokempo.entities.Player;

public class RoundResult {

    private boolean _hasWinner;
    private Player winner;
    private MoveEnum winnerMove;
    private Player loser;
    private MoveEnum loserMove;

    private RoundResult(boolean hasWinner, MoveEnum move) throws IllegalArgumentException {
        this._hasWinner = hasWinner;
        setWinnerMove(move);
        if (_hasWinner) {
            throw new IllegalArgumentException("No caso de haver um vencedor, tanto ele quanto o perdedor  devem ser informados");
        }
    }

    private RoundResult(boolean hasWinner, Player winner, MoveEnum winnerMove, Player loser, MoveEnum loserMove) throws IllegalArgumentException {
        this._hasWinner = hasWinner;
        if (_hasWinner) {
            setWinner(winner);
            setWinnerMove(winnerMove);
            setLoser(loser);
            setLoserMove(loserMove);
            if(MoveEnumConcerns.areEquals(winnerMove, loserMove)) {
                throw new IllegalArgumentException("No caso de haver um vencedor, as jogadas devem ser diferentes");
            }
            if(PlayerConcerns.areEquals(winner, loser)) {
                throw new IllegalArgumentException("O vencedor e o perdedor não podem ser o mesmo jogador");
            }
        }
    }

    public boolean hasWinner() {
        return _hasWinner;
    }

    public Player getWinner() {
        return winner;
    }

    private void setWinner(Player winner) {
        if (ObjectConcerns.isNull(winner)) {
            throw new IllegalArgumentException("O jogador vencedor não pode ser nulo");
        }
        this.winner = winner;
    }

    public MoveEnum getWinnerMove() {
        return winnerMove;
    }

    private void setWinnerMove(MoveEnum move) {
        if (ObjectConcerns.isNull(move)) {
            throw new IllegalArgumentException("A jogada vencedora não pode ser nula");
        }
        this.winnerMove = move;
    }

    public Player getLoser() {
        return loser;
    }

    private void setLoser(Player loser) {
        if (ObjectConcerns.isNull(loser)) {
            throw new IllegalArgumentException("O jogador perdedor não pode ser nulo");
        }
        this.loser = loser;
    }

    public MoveEnum getLoserMove() {
        return loserMove;
    }

    private void setLoserMove(MoveEnum move) {
        if (ObjectConcerns.isNull(move)) {
            throw new IllegalArgumentException("A jogada perdedora não pode ser nula");
        }
        this.loserMove = move;
    }

    @Override
    public String toString() {
        if(_hasWinner) {
            return "O jogador " + winner.toString() + " ganhou jogando " + winnerMove.toString() + " contra " + loserMove.toString() + " do " + loser.toString();
        } else {
            return "Houve um empate onde ambos jogaram " + winnerMove.toString();
        }
    }

    public static RoundResult WinnerResult(Player winner, MoveEnum winnerMove, Player loser, MoveEnum loserMove) {
        RoundResult result = new RoundResult(true, winner, winnerMove, loser, loserMove);
        return result;
    }

    public static RoundResult DrawResult(MoveEnum move) {
        RoundResult result = new RoundResult(false, move);
        return result;
    }
}
