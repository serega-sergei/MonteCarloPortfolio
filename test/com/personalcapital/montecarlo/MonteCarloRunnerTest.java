package com.personalcapital.montecarlo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.personalcapital.model.Portfolio;

public class MonteCarloRunnerTest {
    private MonteCarloRunner runner;
    private PortfolioProcessor processor;
    private Portfolio portfolio;
    private double inflationRate;
    private int itersNum;

    @Before
    public void setUp() {
        portfolio = new Portfolio(new BigDecimal(100), 10, 10, 15);
        inflationRate = 3.5;
        processor = new PortfolioProcessor(portfolio, inflationRate);
        itersNum = 10000;
        runner = new MonteCarloRunner(itersNum, processor);
    }

    @Test
    public void runSimulationTest() {
        BigDecimal[] result = runner.runSimulation();

        assertEquals(result.length, itersNum);

        for (int i = 0; i < result.length; i++) {
            assert (result[i].doubleValue() >= PortfolioProcessorTest.getLowerBound(portfolio, inflationRate)
                    && result[i].doubleValue() <= PortfolioProcessorTest.getUpperBound(portfolio, inflationRate));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIterationsNumTest() {
        runner.setIterationsNum(0);
    }
}
