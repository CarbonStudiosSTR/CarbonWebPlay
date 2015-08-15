package view;

import controller.InputController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameView extends Application {

    public void startup() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane rootPane = new StackPane();
        Group spriteGroup = new Group();
        ImageView knightView = new ImageView(new Image("sprite/brutal-helm.png"));
        spriteGroup.getChildren().add(knightView);

        rootPane.getChildren().add(spriteGroup);

        final Label positionLabel = new Label("position");
        spriteGroup.getChildren().add(positionLabel);

        knightView.setFocusTraversable(true);
        InputController.initInputController(knightView);

        Scene mainScene = new Scene(rootPane, 800, 600);
        stage.setScene(mainScene);
        stage.show();
    }

}
