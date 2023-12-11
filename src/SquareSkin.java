import javafx.beans.value.*;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

class SquareSkin extends StackPane
{
    static final Image noughtImage = new Image("zero.png");
    static final Image crossImage = new Image("cross.png");

    private final ImageView imageView = new ImageView();

    SquareSkin(final Square square)
    {
        getStyleClass().add("square");

        imageView.setMouseTransparent(true);

        getChildren().setAll(imageView);
        setPrefSize(crossImage.getHeight() + 20, crossImage.getHeight() + 20);

        setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override public void handle(MouseEvent mouseEvent) {square.pressed();}
        });

        square.stateProperty().addListener(new ChangeListener<Square.State>()
        {
            @Override public void changed(ObservableValue<? extends Square.State> observableValue, Square.State oldState, Square.State state)
            {
                switch (state)
                {
                    case EMPTY:  imageView.setImage(null);        break;
                    case ZERO: imageView.setImage(noughtImage); break;
                    case CROSS:  imageView.setImage(crossImage);  break;
                }
            }
        });
    }
}