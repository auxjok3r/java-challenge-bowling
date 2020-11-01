package com.jkr;

public class ScoreBehaviorProvider {

    public static ScoreBehavior geScoreBehavior(Frame frame){
        if (frame.getPoints().length == 1 && frame.sumOfPoints() == Constants.STRIKE_VALUE) {
            return new StrikeScoreBehavior();
        }
        if (frame.getPoints().length == 2 && frame.sumOfPoints() == Constants.MAX_PIN_FALL) {
            return new SpareScoreBehavior();
        }
        return new SimpleScoreBehavior();
    }
}
