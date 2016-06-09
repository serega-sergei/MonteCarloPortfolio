package com.personalcapital.utils;

import org.junit.Before;
import org.junit.Test;

public final class RandomGaussianTest {
    private double mean;
    private double standardDeviation;

    @Before
    public void setUp() {
        mean = 0;
        standardDeviation = 1;
    }

    @Test
    public void getGaussianTest() {
        Double gaussian = RandomGaussian.getGaussian(mean, standardDeviation);

        assert (gaussian >= -3 && gaussian <= 3);
    }
}
