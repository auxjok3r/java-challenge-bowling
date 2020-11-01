package com.jkr;

import java.util.List;

public interface ScoreManager {
    List<PlayerGame> getPlayerGames();
    void processData();
}
