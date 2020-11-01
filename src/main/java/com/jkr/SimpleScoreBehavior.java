package com.jkr;

import java.util.List;

public class SimpleScoreBehavior implements ScoreBehavior {
    @Override
    public void score(int frameIndex, List<Frame> frames) throws Exception {
        int score = (frameIndex == 1)
                        ? Constants.MIN_PIN_FALL
                        : FrameManager.getFrameByIndex(frameIndex - 1, frames).getScore();
        Frame currentFrame = FrameManager.getFrameByIndex(frameIndex, frames);
        int currentSumOfPoints = currentFrame.sumOfPoints();

        if (frameIndex != Constants.FRAME_COUNT
                && currentSumOfPoints > Constants.MAX_PIN_FALL) {
            throw new Exception("La suma de puntos exede el maximo ".concat(Integer.toString(currentSumOfPoints)));
        }
        score += currentFrame.sumOfPoints();
        currentFrame.setScore(score);
    }
}
