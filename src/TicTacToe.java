import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application
{
    @Override public void start(Stage stage) throws Exception
    {
        GameManager gameManager = new GameManager();

        Scene scene = gameManager.getGameScene();
        scene.getStylesheets().add(
                getResource(
                        "tictactoe-blueskin.css"
                )
        );

        stage.setTitle("крестики-нолики");
        stage.getIcons().add(SquareSkin.crossImage);
        stage.setScene(scene);
        stage.show();
    }

    private String getResource(String resourceName)
    {
        return getClass().getResource(resourceName).toExternalForm();
    }

    public static void main(String[] args)
    {
        Application.launch(TicTacToe.class);
    }
}

