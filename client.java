import com.dev.Exceptions.CellAlreadyOccupiedException;
import com.dev.Exceptions.OutOfDimensionException;
import com.dev.beans.Game;
import com.dev.beans.Player;
import com.dev.beans.PlayerType;
import com.dev.beans.Symbol;
import com.dev.controllers.GameController;
import com.dev.strategies.winning.ColumnWinningStrategy;
import com.dev.strategies.winning.DiagnalWinningStrategy;
import com.dev.strategies.winning.RowWinningStrategy;
import com.dev.strategies.winning.WinningStrategies;

import java.util.List;

public class client {
    public static void main(String[] args) throws OutOfDimensionException, CellAlreadyOccupiedException {

        GameController gameController = new GameController();

        List<WinningStrategies> winningStrategies = List.of(new ColumnWinningStrategy(), new DiagnalWinningStrategy(),new RowWinningStrategy());

        Player player = new Player("Dheeraj", new Symbol('X'), PlayerType.PLAYER);
        Player player1 = new Player("Deepthi", new Symbol('O'), PlayerType.PLAYER);
        List<Player> players = List.of(player, player1);

        Game game= gameController.startGame(3,players,winningStrategies);

        gameController.
                makeMove(game);

    }

}
