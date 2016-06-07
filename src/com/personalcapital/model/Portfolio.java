package com.personalcapital.model;

import java.math.BigDecimal;

public class Portfolio {
    private int term;
    private BigDecimal deposit;
    private double mean;
    private double sd;
    private double inflationRate;

    public Portfolio(BigDecimal deposit, int term, double mean, double sd, double inflationRate) {
        super();
        this.deposit = deposit;
        this.term = term;
        this.mean = mean / 100;
        this.sd = sd / 100;
        this.inflationRate = inflationRate / 100;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getSd() {
        return sd;
    }

    public void setSd(double sd) {
        this.sd = sd;
    }

    public double getInflationRate() {
        return inflationRate;
    }

    public void setInflationRate(double inflationRate) {
        this.inflationRate = inflationRate;
    }
}
