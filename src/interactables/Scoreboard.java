package src.interactables;

import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class Scoreboard {
    private Text text;

    public Scoreboard(Pane root) {
        text = new Text(10, 20, "Score: 0");
        text.setFill(Color.BLACK);
        root.getChildren().add(text);
    }

    public void updateScore(int score) {
        text.setText("Score: " + score);
    }

    public void setMessage(String msg) {
        text.setText(msg);
    }
}
