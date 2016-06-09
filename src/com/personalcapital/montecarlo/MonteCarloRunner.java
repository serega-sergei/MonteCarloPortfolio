package com.personalcapital.montecarlo;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Class for running Monte Carlo simulations
 * 
 * @author Siarhei Siryk
 *
 */
public class MonteCarloRunner {
    private BigDecimal[] values;
    private int iterationsNum;
    private MonteCarlo montecarlo;

    public MonteCarloRunner(int iterationsNum, MonteCarlo montecarlo) {
        super();
        setIterationsNum(iterationsNum);
        this.values = new BigDecimal[iterationsNum];
        this.montecarlo = montecarlo;
    }

    /**
     * Runs Monte Carlo simulation using given number of experiments
     * "iterationsNum" based on generated values from MonteCarlo implementations
     * 
     * @return Monte Carlo simulation results array
     */
    public BigDecimal[] runSimulation() {
        values = new BigDecimal[iterationsNum];

        for (int i = 0; i < iterationsNum; i++) {
            values[i] = montecarlo.generateValue();
        }

        Arrays.sort(values);

        return values;
    }

    public BigDecimal[] getValues() {
        return values;
    }

    public void setValues(BigDecimal[] values) {
        this.values = values;
    }

    public int getIterationsNum() {
        return iterationsNum;
    }

    public void setIterationsNum(int iterationsNum) {
        if (iterationsNum <= 0)
            throw new IllegalArgumentException("Number of iterations can not be nagative or zero");
        this.iterationsNum = iterationsNum;
    }

    public MonteCarlo getMontecarlo() {
        return montecarlo;
    }

    public void setMontecarlo(MonteCarlo montecarlo) {
        this.montecarlo = montecarlo;
    }
}
