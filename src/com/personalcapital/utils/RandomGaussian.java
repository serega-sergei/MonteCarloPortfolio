package com.personalcapital.utils;

import java.util.Random;

/**
 * Utility class for generation of random gaussian number based on standard
 * deviation and mean
 * 
 * @author Siarhei Siryk
 *
 */
public final class RandomGaussian {
    private static Random fRandom = new Random();

    /**
     * Generate random gaussian number based on standard deviation and mean
     * 
     * @param mean
     * @param standardDeviation
     * @return generated random number
     */
    public static double getGaussian(double mean, double standardDeviation) {
        return mean + fRandom.nextGaussian() * standardDeviation;
    }
}
