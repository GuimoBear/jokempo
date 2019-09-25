package org.guimo.jokempo.concerns;

import org.guimo.jokempo.entities.Player;

public class PlayerConcerns {
    public static void validatePlayers(Player player1, Player player2) throws IllegalArgumentException {
        if(ObjectConcerns.isNull(player1)) {
            throw new IllegalArgumentException("O jogador 1 deve ser informado");
        }
        if(ObjectConcerns.isNull(player2)) {
            throw new IllegalArgumentException("O jogador 2 deve ser informado");
        }
        if(areEquals(player1, player2)) {
            throw new IllegalArgumentException("Os jogadores não podem ser a mesma pessoa");
        }
    }

    public static boolean areEquals(Player left, Player right) {
        if(ObjectConcerns.isNull(left) && ObjectConcerns.isNull(right)) {
            return true;
        } else if(ObjectConcerns.isNull(left) || ObjectConcerns.isNull(right)) {
            return false;
        }
        return left.equals(right);
    }
}
