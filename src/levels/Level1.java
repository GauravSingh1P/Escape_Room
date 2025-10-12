package src.levels;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.util.Random;

public class Level1 extends Application {

    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private static final int PLAYER_RADIUS = 15;

    private Circle player;
    private Rectangle chest1, chest2;
    private boolean keyFound = false;
    private Text message;

    private double playerSpeed = 5;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Rooms
        Rectangle room1 = new Rectangle(50, 50, 200, 300);
        room1.setFill(Color.LIGHTBLUE);
        Rectangle room2 = new Rectangle(350, 50, 200, 300);
        room2.setFill(Color.LIGHTGREEN);

        // Player
        player = new Circle(PLAYER_RADIUS, Color.RED);
        player.setCenterX(100);
        player.setCenterY(200);

        // Chests
        chest1 = new Rectangle(50, 50, Color.BROWN);
        chest2 = new Rectangle(50, 50, Color.BROWN);

        placeChestsRandomly();

        // Message
        message = new Text();
        message.setX(50);
        message.setY(20);
        message.setFill(Color.BLACK);
        message.setText("Find the key!");

        root.getChildren().addAll(room1, room2, chest1, chest2, player, message);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Player movement
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) player.setCenterY(player.getCenterY() - playerSpeed);
            if (e.getCode() == KeyCode.DOWN) player.setCenterY(player.getCenterY() + playerSpeed);
            if (e.getCode() == KeyCode.LEFT) player.setCenterX(player.getCenterX() - playerSpeed);
            if (e.getCode() == KeyCode.RIGHT) player.setCenterX(player.getCenterX() + playerSpeed);
        });

        // Chest interaction
        chest1.setOnMouseClicked(e -> openChest(chest1));
        chest2.setOnMouseClicked(e -> openChest(chest2));

        primaryStage.setTitle("Level 1 - Find the Key");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void placeChestsRandomly() {
        Random rand = new Random();
        // Room 1: 50,50 to 250,350
        // Room 2: 350,50 to 550,350
        chest1.setX(rand.nextBoolean() ? rand.nextInt(150) + 50 : rand.nextInt(150) + 350);
        chest1.setY(rand.nextInt(250) + 50);
        chest2.setX(rand.nextBoolean() ? rand.nextInt(150) + 50 : rand.nextInt(150) + 350);
        chest2.setY(rand.nextInt(250) + 50);

        // Randomly assign key to one chest
        if (rand.nextBoolean()) {
            chest1.setUserData(true);
            chest2.setUserData(false);
        } else {
            chest1.setUserData(false);
            chest2.setUserData(true);
        }
    }

    private void openChest(Rectangle chest) {
        boolean hasKey = (boolean) chest.getUserData();
        if (keyFound) {
            message.setText("Key already found!");
            return;
        }

        if (hasKey) {
            message.setText("You found the key! Level Complete!");
            chest.setFill(Color.GOLD);
            keyFound = true;
        } else {
            message.setText("No key here, try the other chest.");
            chest.setFill(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

