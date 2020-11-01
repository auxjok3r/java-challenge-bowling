package com.jkr;

import java.util.List;

public class StrikeScoreBehavior implements ScoreBehavior {

    private final int NEXT_POINT_SIZE = 2;
    private AllPinScore allPinScore;

    public StrikeScoreBehavior() {
        this.allPinScore = new AllPinScore(NEXT_POINT_SIZE);
    }

    @Override
    public void score(int frameIndex, List<Frame> frames) throws Exception {
        this.allPinScore.score(frameIndex,frames);
    }
}
