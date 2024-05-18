package com.csiiproject.javaFX;

public class SharedState {
    private static SharedState instance = null;
    private int laneNumber;

    private SharedState() {
        // Private constructor to prevent instantiation
    }

    public static SharedState getInstance() {
        if (instance == null) {
            instance = new SharedState();
        }
        return instance;
    }

    public int getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(int laneNumber) {
        this.laneNumber = laneNumber;
    }
}