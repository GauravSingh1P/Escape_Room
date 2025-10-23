package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
         Game game = new Game(); // create your game logic object
        Scene scene = new Scene(game.getRoot(), 800, 600);
        
        
        primaryStage.setTitle("My JavaFX Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        game.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

