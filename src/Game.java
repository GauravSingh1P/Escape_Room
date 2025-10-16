package resources;

import javafx.stage.Stage;
import levels.Level1;

public class Game {
    private Stage stage;

    public Game(Stage stage) {
        this.stage = stage;
    }

    public void startGame() {
        Level1 level1 = new Level1(stage, this);
        level1.start();
    }

    public void nextLevel() {
        System.out.println("Level 2 unlocked! 🚪");
        // Later, you can load Level2 here.
    }
}
