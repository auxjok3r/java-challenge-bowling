package com.jkr;

import java.util.List;

public class ConsoleGamePrinter implements GamePrinter {
    @Override
    public void print(List<PlayerGame> playerGames) {
       String header = buildHeader();
       String body = buildBody(playerGames);
        System.out.println(header.concat("\n").concat(body));
    }

    private String buildBody(List<PlayerGame> playerGames) {
        String body = "";
        for (PlayerGame playerGame: playerGames){
            body = body.concat(buildPlayerGame(playerGame));
        }
        return body;
    }

    private String buildPlayerGame(PlayerGame playerGame) {
        return playerGame.getName().concat("\n").
                concat(buildPinFall(playerGame.getFrames())).
                concat(buildScorePoints(playerGame.getFrames()));
    }

    private String buildHeader() {
        String header = "Frame";
        for (int i = 1; i <= Constants.FRAME_COUNT; i++) {
            header = header.concat(String.format("\t\t%d", i));
        }
        return header;
    }

    private String buildPinFall(List<Frame> frames) {
        String result = "PinFalls\t";
        for (Frame frame: frames){
            result = result.concat(buildPoints(frame));
        }
        return result.concat("\n");
    }

    private String buildPoints(Frame frame) {
        if (frame.getStringPoints().length == 1
                && frame.getStringPoints()[0].equals(Constants.STRING_STRIKE_VALUE)) {
            return String.format(frame.getIndex() == 1 ? "\t%s" : "\t\t%s", Constants.STRIKE);
        }
        if (frame.getStringPoints().length == 2 && frame.sumOfPoints() == Constants.MAX_PIN_FALL) {
            return String.format(frame.getIndex() == 1 ? "%s\t%s" : "\t%s\t%s", frame.getStringPoints()[0], Constants.SPARE);
        }
        String result = "";
        for (String stringPoint : frame.getStringPoints()) {
            result = result.concat("\t").concat(stringPoint.equals(Constants.STRING_MAX_PIN_FALL) ?
                    Constants.STRIKE : stringPoint);
        }
        return  result;
    }

    private String buildScorePoints(List<Frame> frames) {
        String result = "Score";
        for(Frame frame: frames){
            result = result.concat("\t\t").concat(String.format("%d", frame.getScore()));
        }
        return  result.concat("\n");
    }
}
