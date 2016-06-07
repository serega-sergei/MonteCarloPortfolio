package com.personalcapital.utils;

import java.util.Random;

public final class RandomGaussian {
    private Random fRandom = new Random();

    private double mean = 0.0f;
    private double standardDeviation = 1.0f;

    public RandomGaussian() {
        super();
        mean = 0.0f;
        standardDeviation = 1.0f;
    }

    public RandomGaussian(double mean, double sd) {
        super();
        this.mean = mean;
        this.standardDeviation = sd;
    }

    public double getGaussian() {
        return mean + fRandom.nextGaussian() * standardDeviation;
    }
}
