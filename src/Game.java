package src;

import java.util.ArrayList;
import java.util.List;
import src.levels.*;

public class Game {
    private Player player;
    private List<Level> levels;
    private int currentLevelIndex;

    public Game() {
        player = new Player(100, 200);
        levels = new ArrayList<>();
        levels.add(new Level1()); // add other levels similarly
        currentLevelIndex = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public Level getCurrentLevel() {
        if (currentLevelIndex < levels.size()) {
            return levels.get(currentLevelIndex);
        }
        return null;
    }

    public void nextLevel() {
        currentLevelIndex++;
    }

    public boolean isGameFinished() {
        return currentLevelIndex >= levels.size();
    }
}

