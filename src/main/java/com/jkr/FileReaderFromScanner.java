package com.jkr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderFromScanner implements FileReader {

    private List<PlayerGame> playerGames;
    private Scanner scanner;

    public FileReaderFromScanner(Scanner scanner) {
        this.playerGames = new ArrayList<>();
        this.scanner = scanner;
    }

    @Override
    public List<PlayerGame> readPlayerGames() {
        while (this.scanner.hasNext()) {
            this.processInput(this.scanner.nextLine());
        }
        return playerGames;
    }

    private void processInput(String nextLine) {
        if (nextLine == null || nextLine.isEmpty()) {
            return;
        }
        String[] values = nextLine.trim().replace("\\t"," ").split(" ");
        if (values.length != 2) {
            System.out.println("No se puede procesar la linea ".concat(nextLine));
            System.exit(-1);
        }
        createOrUpdatePlayerGame(values[0], values[1]);
    }

    private void createOrUpdatePlayerGame(String playerName, String score){
        PlayerGame playerGame = getPlayerGame(playerName);
        if(playerGame == null){
            playerGame = new PlayerGame(playerName);
            this.playerGames.add(playerGame);
        }
        playerGame.getScores().add(score);
    }

    private PlayerGame getPlayerGame(String playerName){
        for(PlayerGame playerGame : this.playerGames){
            if (playerGame.getName().equals(playerName)){
                return  playerGame;
            }
        }
        return null;
    }
}
