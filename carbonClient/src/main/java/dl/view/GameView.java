package dl.view;

import dl.view.ui.DLFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static javafx.scene.input.KeyCombination.NO_MATCH;

public class GameView extends Application {

   public void startup(String[] args) {

      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {

      ApplicationContext appContext = new ClassPathXmlApplicationContext("/META-INF/spring/dl-spring-ctx.xml");
      DLFxmlLoader loader = appContext.getBean(DLFxmlLoader.class);

      Parent root = loader.load();
      Scene mainScene = new Scene(root, 1366, 768);
      mainScene.getStylesheets().add("ui/skins/DarklandDefault.css");

      primaryStage.setTitle("Darkland");
     // primaryStage.initStyle(UNDECORATED);
     // primaryStage.centerOnScreen();
      primaryStage.setFullScreenExitKeyCombination(NO_MATCH);
      primaryStage.setScene(mainScene);
     // primaryStage.setFullScreen(true);
      primaryStage.show();
   }
}
