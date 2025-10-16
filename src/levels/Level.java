package levels;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import resources.Game;
import resources.Player;

public class Level1 {
    private Stage stage;
    private Game game;
    private Player player;
    private Rectangle chest1, chest2;
    private boolean hasKey = false;

    public Level1(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
    }

    public void start() {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400, Color.BEIGE);

        // Player setup
        player = new Player(50, 50);
        root.getChildren().add(player.sprite);

        // Two chests
        chest1 = new Rectangle(200, 200, 50, 50);
        chest1.setFill(Color.SADDLEBROWN);
        chest2 = new Rectangle(400, 200, 50, 50);
        chest2.setFill(Color.SADDLEBROWN);

        root.getChildren().addAll(chest1, chest2);

        // Controls
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) player.move(0, -10);
            if (e.getCode() == KeyCode.S) player.move(0, 10);
            if (e.getCode() == KeyCode.A) player.move(-10, 0);
            if (e.getCode() == KeyCode.D) player.move(10, 0);
            if (e.getCode() == KeyCode.E) checkChest();
        });

        stage.setScene(scene);
        stage.setTitle("Escape Room - Level 1");
        stage.show();
    }

    private void checkChest() {
        if (player.sprite.getBoundsInParent().intersects(chest1.getBoundsInParent())) {
            showMessage("This chest is empty!");
        } else if (player.sprite.getBoundsInParent().intersects(chest2.getBoundsInParent())) {
            if (!hasKey) {
                hasKey = true;
                showMessage("You found a key! Level 2 unlocked!");
                game.nextLevel();
            } else {
                showMessage("You already took the key!");
            }
        }
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
