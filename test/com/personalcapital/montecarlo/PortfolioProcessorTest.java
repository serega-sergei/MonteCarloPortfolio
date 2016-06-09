package com.personalcapital.montecarlo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.MathContext;

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

        assert (result.doubleValue() <= getUpperBound(processor.getPortfolio(), processor.getInflationRate())
                && result.doubleValue() >= getLowerBound(processor.getPortfolio(), processor.getInflationRate()));
    }

    @Test
    public void setPortfolioTest() {
        try {
            processor.setPortfolio(null);
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), containsString("Portfolio can not be null"));
        }
    }

    public static double getUpperBound(Portfolio portfolio, double inflationRate) {
        BigDecimal upperBound = portfolio.getDeposit()
                .multiply(
                        BigDecimal.valueOf(1 + portfolio.getMean() / 100 + 3 * portfolio.getStandardDeviation() / 100),
                        MathContext.DECIMAL128)
                .multiply(BigDecimal.valueOf(portfolio.getTerm()));

        return inflationAdj(upperBound, portfolio, inflationRate).doubleValue();
    }

    public static double getLowerBound(Portfolio portfolio, double inflationRate) {
        BigDecimal lowerBound = portfolio.getDeposit()
                .multiply(
                        BigDecimal.valueOf(1 + portfolio.getMean() / 100 - 3 * portfolio.getStandardDeviation() / 100),
                        MathContext.DECIMAL128)
                .multiply(BigDecimal.valueOf(portfolio.getTerm()));

        return inflationAdj(lowerBound, portfolio, inflationRate).doubleValue();
    }

    private static BigDecimal inflationAdj(BigDecimal value, Portfolio portfolio, double inflationRate) {
        value = value.divide(BigDecimal.valueOf(Math.pow(1 + (inflationRate / 100), portfolio.getTerm())),
                MathContext.DECIMAL128);

        return value;
    }

}
