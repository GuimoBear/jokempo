package org.guimo.jokempo.valueobjects;

import org.guimo.jokempo.concerns.CollectionConcerns;
import org.guimo.jokempo.concerns.ObjectConcerns;
import org.guimo.jokempo.concerns.PlayerConcerns;
import org.guimo.jokempo.entities.Player;

import java.util.Collection;

public class GameResult {
    private final Player player1;
    private final long player1Victories;

    private Player player2;
    private final long player2Victories;

    private final long drawResults;

    private Collection<RoundResult> roundResults;

    public GameResult(Player player1, Player player2, Collection<RoundResult> roundResults) throws IllegalArgumentException {
        PlayerConcerns.validatePlayers(player1, player2);
        if (CollectionConcerns.isEmpty(roundResults)) {
            throw new IllegalArgumentException("Devem ser informados os resultados das rodadas");
        }
        this.player1 = player1;
        this.player2 = player2;
        this.roundResults = roundResults;

        this.player1Victories = victoryNumber(this.player1, this.roundResults);
        this.player2Victories = victoryNumber(this.player2, this.roundResults);
        this.drawResults = roundResults.size() - player1Victories - player2Victories;
    }

    private long victoryNumber(Player player, Collection<RoundResult> results) {
        return results.stream().filter(result -> result.hasWinner() && result.getWinner().equals(player)).count();
    }

    public boolean hasWinner() {
        return player2Victories != player1Victories;
    }

    public Player getWinner() {
        if(player1Victories > player2Victories) {
            return player1;
        } else if (player2Victories > player1Victories) {
            return player2;
        }
        return null;
    }

    private String playerStats(Player player, long victories) {
        return player.toString() + "\n\tVitórias: " + victories + "\n";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (RoundResult result : roundResults) {
            builder.append(result.toString()  + "\n");
        }
        builder.append("Resultado final: \n");
        builder.append(playerStats(player1, player1Victories));
        builder.append(playerStats(player2, player2Victories));
        builder.append("Empates: " + drawResults + "\n");
        if(hasWinner()) {
            builder.append("Vencedor: " + getWinner().toString());
        }
        return builder.toString();
    }
}
