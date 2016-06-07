package com.personalcapital.utils;

import java.util.Random;

public final class RandomGaussian {
    private static Random fRandom = new Random();

    public static double getGaussian(double mean, double standardDeviation) {
        return mean + fRandom.nextGaussian() * standardDeviation;
    }
}
