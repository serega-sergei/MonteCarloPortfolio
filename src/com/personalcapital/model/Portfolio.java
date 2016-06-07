package com.personalcapital.model;

import java.math.BigDecimal;

public class Portfolio {
    private int term;
    private BigDecimal deposit;
    private double mean;
    private double standardDeviation;

    public Portfolio(BigDecimal deposit, int term, double mean, double sd) {
        super();
        setDeposit(deposit);
        setTerm(term);
        this.mean = mean / 100;
        this.standardDeviation = sd / 100;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        if (term <= 0)
            throw new IllegalArgumentException("Term can not be nagative or zero");

        this.term = term;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        if (deposit.doubleValue() <= 0)
            throw new IllegalArgumentException("Deposit can not be nagative or zero");

        this.deposit = deposit;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    @Override
    public String toString() {
        return "Portfolio [term=" + term + ", deposit=" + deposit + ", mean=" + String.format("%.6f", mean)
                + ", standardDeviation=" + String.format("%.6f", standardDeviation) + "]";
    }
}
