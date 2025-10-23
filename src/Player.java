package src;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Player {
    private Rectangle node;
    private double speed = 5;

    public Player() {
        node = new Rectangle(40, 40, Color.BLUE);
        node.setX(50);
        node.setY(50);
    }

    public Rectangle getNode() {
        return node;
    }

    public void update() {
        // Example: simple automatic movement or keyboard input
        // node.setX(node.getX() + speed);
    }

    public boolean hasReachedGoal() {
        // Example condition for completing level
        return node.getX() > 700;
    }
}