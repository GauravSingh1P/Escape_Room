package src;

import src.levels.Level1;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Game game;

    @Override
    public void start(Stage primaryStage) {
        game = new Game();
        // For now, we can just launch Level1 JavaFX scene
        Level1 level1 = (Level1) game.getCurrentLevel();
        try {
            level1.start(new Player(100, 200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

