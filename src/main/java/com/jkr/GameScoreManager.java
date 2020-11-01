package com.jkr;

import java.util.List;

public class GameScoreManager implements ScoreManager {

    private List<PlayerGame> playerGames;
    private ScoreCalculator scoreCalculator;

    public GameScoreManager(List<PlayerGame> playerGames) {
        this.playerGames = playerGames;
        this.scoreCalculator = new ScoreCalculator();
    }


    @Override
    public List<PlayerGame> getPlayerGames() {
        return this.playerGames;
    }

    @Override
    public void processData() {
        for (PlayerGame playerGame : this.playerGames) {
            this.scoreCalculator.calculateScore(playerGame);
        }
    }
}
