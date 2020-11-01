package com.jkr;

import java.util.List;

public class AllPinScore {
    private int nextPointSize;

    public AllPinScore(int nextPointSize) {
        this.nextPointSize = nextPointSize;
    }
    
    public void score(int frameIndex, List<Frame> frames) throws Exception {
        int score =
                (frameIndex == 1)
                        ? Constants.MIN_PIN_FALL
                        : FrameManager.getFrameByIndex(frameIndex - 1, frames).getScore();
        Frame currentFrame = FrameManager.getFrameByIndex(frameIndex, frames);
        score += currentFrame.sumOfPoints();
        int nextValueCounter = 0;
        int nextFrameDistance = 1;
        while (nextValueCounter < this.nextPointSize) {
            final Frame nextFrame = FrameManager.getFrameByIndex(frameIndex + nextFrameDistance, frames);
            final int pointSize = nextFrame.getPoints().length;
            nextFrameDistance++;
            if (pointSize == 3) {
                if (nextValueCounter == 0) {
                    score += (nextFrame.getPoints()[0] + nextFrame.getPoints()[1]);
                    nextValueCounter += 2;
                }
                if (nextValueCounter == 1) {
                    score += nextFrame.getPoints()[0];
                    nextValueCounter += 1;
                }
                continue;
            }
            if (nextValueCounter == 0) {
                score += this.nextPointSize == 1 ? nextFrame.getPoints()[0] : nextFrame.sumOfPoints();
                nextValueCounter += pointSize;
                continue;
            }
            if (nextValueCounter == 1) {
                score += nextFrame.getPoints()[0];
                nextValueCounter += pointSize;
            }
        }
        currentFrame.setScore(score);
    }
}
