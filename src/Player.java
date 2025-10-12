package src;

public class Player {
    private double x, y;
    private int score;

    public Player(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public int getScore() { return score; }
    public void addScore(int points) { score += points; }
}


