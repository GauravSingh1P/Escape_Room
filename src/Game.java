package src;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class Game {
    private final Pane root;
    private final Player player;
    private int currentLevel = 1;
    private static final int TOTAL_LEVELS = 10;

    public Game() {
        root = new Pane();
        root.setPrefSize(800, 600); // size of your game window

        player = new Player();
        root.getChildren().add(player.getNode());
    }

    public Pane getRoot() {
        return root;
    }

    public void start() {
        // Start game loop
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        gameLoop.start();
    }

    private void update() {
        // Handle player movement, collisions, level progression
        player.update();

        // Simple level progression example
        if (player.hasReachedGoal()) {
            nextLevel();
        }
    }

    private void nextLevel() {
        currentLevel++;
        if (currentLevel > TOTAL_LEVELS) {
            System.out.println("You won!");
            // Optionally stop the game or reset
        } else {
            System.out.println("Level " + currentLevel);
            // Load new level objects, reset player position, etc.
        }
    }
}
