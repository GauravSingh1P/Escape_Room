package src.interactables;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Utils {
    // Simple collision check: circle vs rectangle
    public static boolean isColliding(Circle player, Rectangle obj) {
        double closestX = clamp(player.getCenterX(), obj.getX(), obj.getX() + obj.getWidth());
        double closestY = clamp(player.getCenterY(), obj.getY(), obj.getY() + obj.getHeight());
        double dx = player.getCenterX() - closestX;
        double dy = player.getCenterY() - closestY;
        return (dx * dx + dy * dy) < (player.getRadius() * player.getRadius());
    }

    private static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}
