package com.personalcapital.montecarlo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.personalcapital.model.Portfolio;

public class PortfolioProcessorTest {
    private PortfolioProcessor processor;
    private Portfolio portfolio;
    private double inflationRate;

    @Before
    public void setUp() {
        portfolio = new Portfolio(new BigDecimal(100), 10, 10, 15);
        inflationRate = 3.5;
        processor = new PortfolioProcessor(portfolio, inflationRate);
    }

    @Test
    public void generateTermYearsValueTest() {
        BigDecimal result = processor.generateTermYearsValue();
        
        assert(result.doubleValue() > 0);
    }

    @Test
    public void setPortfolioTest() {
        try {
            processor.setPortfolio(null);
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), containsString("Portfolio can not be null"));
        }
    }

}
