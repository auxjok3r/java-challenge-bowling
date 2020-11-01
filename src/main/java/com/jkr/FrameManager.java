package com.jkr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FrameManager {

    public static Frame getFrameByIndex(int index, List<Frame> frames) throws Exception {
        for (Frame frame: frames){
            if(frame.getIndex() == index){
                return frame;
            }
        }
        throw new Exception("No existe el frame que se esa buscando ".concat(Integer.toString(index)));
    }

    public List<Frame> buildFrames(PlayerGame playerGame) throws Exception {
        playerGame.setFrames(buildFrames(playerGame.getScores()));
        return playerGame.getFrames();
    }

    private List<Frame> buildFrames(List<String> scores) throws Exception {
        Iterator<String> iterator = scores.iterator();
        List<Frame> frames = new ArrayList<>();
        int index = 1;
        while (iterator.hasNext()) {
            String currentScore = iterator.next();
            int currentValue = parseToNumericScore(currentScore);
            if (currentValue == Constants.STRIKE_VALUE && index != Constants.FRAME_COUNT) {
                String[] points = {currentScore};
                int[] intPoints = {parseToNumericScore(currentScore)};
                frames.add(new Frame(index, points, intPoints));
                index++;
                continue;
            }
            if (index != Constants.FRAME_COUNT) {
                String firstShot = iterator.next();
                String[] points = {currentScore, firstShot};
                int[] intPoints = {parseToNumericScore(currentScore), parseToNumericScore(firstShot)};
                frames.add(new Frame(index, points, intPoints));
                index++;
            } else {
                String firstShot = iterator.next();
                String secondShot = iterator.next();
                String[] points = {currentScore, firstShot, secondShot};
                int[] intPoints = {parseToNumericScore(currentScore), parseToNumericScore(firstShot),
                        parseToNumericScore(secondShot)};
                frames.add(new Frame(index, points, intPoints));
                index++;
            }
        }
        return frames;
    }

    private int parseToNumericScore(String score) throws Exception {
        if (score == null) {
            return Constants.MIN_PIN_FALL;
        }
        String formattedScore = score.toUpperCase();
        if (Constants.FAULT.equals(formattedScore)) {
            return Constants.MIN_PIN_FALL;
        }
        try {
            int points = Integer.parseInt(formattedScore);
            if (points < Constants.MIN_PIN_FALL || points > Constants.MAX_PIN_FALL) {
                fireException(score);
            }
            return points;
        } catch (Exception exception) {
            fireException(score);
        }
        return Constants.MIN_PIN_FALL;
    }

    private void fireException(String score) throws Exception {
        throw new Exception("Valor invalido para el juego ".concat(score));
    }
}
