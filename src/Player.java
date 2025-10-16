package resources;

import javafx.scene.shape.Rectangle;

public class Player {
    public Rectangle sprite;

    public Player(double x, double y) {
        sprite = new Rectangle(x, y, 30, 30);
        sprite.setStyle("-fx-fill: blue;");
    }

    public void move(double dx, double dy) {
        sprite.setX(sprite.getX() + dx);
        sprite.setY(sprite.getY() + dy);
    }
}
