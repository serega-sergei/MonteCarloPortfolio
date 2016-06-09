package com.personalcapital.montecarlo;

import static org.hamcrest.CoreMatchers.containsString;
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
            assert(result[i].doubleValue() > 0);
        }
    }

    public void setIterationsNumTest() {
        try {
            runner.setIterationsNum(0);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Number of iterations can not be nagative or zero"));
        }
    }
}
