package com.personalcapital.utils;

import java.util.Random;

public final class RandomGaussian {
    private Random fRandom = new Random();

    private double mean = 0.0f;
    private double sd = 1.0f;

    public RandomGaussian() {
        super();
        mean = 0.0f;
        sd = 1.0f;
    }

    public RandomGaussian(double mean, double sd) {
        super();
        this.mean = mean;
        this.sd = sd;
    }

    public double getGaussian() {
        return mean + fRandom.nextGaussian() * sd;
    }
}
