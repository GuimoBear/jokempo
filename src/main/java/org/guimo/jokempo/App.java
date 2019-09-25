package org.guimo.jokempo;

import org.guimo.jokempo.entities.AddictedPlayer;
import org.guimo.jokempo.entities.Player;
import org.guimo.jokempo.entities.RandomPlayer;
import org.guimo.jokempo.services.GameService;
import org.guimo.jokempo.valueobjects.GameResult;
import org.guimo.jokempo.valueobjects.MoveEnum;

public class App {
    public static void main(String[] args) {
        Player player1 = new AddictedPlayer("Player one", MoveEnum.Paper);
        Player player2 = new RandomPlayer("Player two");
        GameService service = new GameService(player1, player2);
        GameResult result = service.play(100);
        System.out.println(result.toString());
    }
}
