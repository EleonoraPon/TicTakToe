import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GameControls extends HBox
{
    GameControls(final GameManager gameManager, final Game game)
    {
        getStyleClass().add("game-controls");

        visibleProperty().bind(game.gameOverProperty());

        Label playAgainLabel = new Label("Играть ещё?");
        playAgainLabel.getStyleClass().add("info");

        Button playAgainButton = new Button("Да");
        playAgainButton.getStyleClass().add("play-again");
        playAgainButton.setDefaultButton(true);
        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {gameManager.newGame();}
        });

        Button exitButton = new Button("Нет");
        playAgainButton.getStyleClass().add("exit");
        exitButton.setCancelButton(true);
        exitButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameManager.quit();
            }
        });

        getChildren().setAll(
                playAgainLabel,
                playAgainButton,
                exitButton
        );
    }
}
