package com.jkr;

import java.util.List;

public class ScoreCalculator {

    private final FrameManager frameBuilder = new FrameManager();

    public void calculateScore(PlayerGame playerGame) {
        try {
            this.frameBuilder.buildFrames(playerGame);
            computeFrameScore(playerGame.getFrames());
        } catch (Exception e) {

        }
    }

    private void computeFrameScore(List<Frame> frames) throws Exception {
        this.validateAttempts(frames);
        for (Frame frame : frames) {
            ScoreBehaviorProvider.geScoreBehavior(frame).score(frame.getIndex(), frames);
        }
    }

    private void validateAttempts(List<Frame> frames) throws Exception {
        if (frames.size() != Constants.FRAME_COUNT) {
            throw new Exception("Cantidad invalida de juegos ".concat(Integer.toString(frames.size())));
        }
    }
}
