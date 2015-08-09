package logic;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import netty.Client;

public class Main extends Application {

    private final String knightSVGPath = "/brutal-helm.svg";

    public static void main(String[] args) {

        launch(args);
        new Client("127.0.0.1", 5555).connect();
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane rootPane = new StackPane();
        Group spriteGroup = new Group(new ImageView(new Image(knightSVGPath)));

        Scene mainScene = new Scene(rootPane, 800, 600);
        stage.setScene(mainScene);
        stage.show();
    }
}
