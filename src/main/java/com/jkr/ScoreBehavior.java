package com.jkr;

import java.util.List;

public interface ScoreBehavior {
    void score(int frameIndex, List<Frame> frames) throws Exception;
}
