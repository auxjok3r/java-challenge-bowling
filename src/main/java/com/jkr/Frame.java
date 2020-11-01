package com.jkr;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Frame {
    private int index;
    private int[] points;
    private int score;
    private String[] stringPoints;

    public Frame(int index, String[] stringPoints, int[] intPoints) {
        this.index = index;
        this.stringPoints = stringPoints;
        this.points = intPoints;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getStringPoints() {
        return stringPoints;
    }

    public void setStringPoints(String[] stringPoints) {
        this.stringPoints = stringPoints;
    }

    public int sumOfPoints() {
        return  Arrays.stream(this.points).sum();
    }
}
