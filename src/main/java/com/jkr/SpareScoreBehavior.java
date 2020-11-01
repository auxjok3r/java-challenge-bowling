package com.jkr;

import java.util.List;

public class SpareScoreBehavior implements ScoreBehavior {

    private final int NEXT_POINT_SIZE = 1;
    private AllPinScore allPinScore;

    public SpareScoreBehavior() {
        this.allPinScore =  new AllPinScore(NEXT_POINT_SIZE);
    }

    @Override
    public void score(int frameIndex, List<Frame> frames) throws Exception {
        this.allPinScore.score(frameIndex, frames);
    }
}
