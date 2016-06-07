package com.personalcapital.montecarlo;

import java.math.BigDecimal;
import java.math.MathContext;

import com.personalcapital.model.Portfolio;
import com.personalcapital.utils.RandomGaussian;

public class PortfolioProcessor implements MonteCarlo {
    private Portfolio portfolio;
    private double inflationRate;

    public PortfolioProcessor(Portfolio portfolio, double inflationRate) {
        super();

        setPortfolio(portfolio);
        this.inflationRate = inflationRate / 100;
    }

    @Override
    public BigDecimal generateValue() {
        return generateTermYearsValue();
    }

    public BigDecimal generateTermYearsValue() {
        BigDecimal res = portfolio.getDeposit();

        for (int i = 0; i < portfolio.getTerm(); i++) {
            res = generateNextYearValue(res);
        }

        return inflationAdj(res);
    }

    private BigDecimal generateNextYearValue(BigDecimal deposit) {
        deposit = deposit.multiply(
                BigDecimal
                        .valueOf(1 + RandomGaussian.getGaussian(portfolio.getMean(), portfolio.getStandardDeviation())),
                MathContext.DECIMAL128);

        return deposit;
    }

    private BigDecimal inflationAdj(BigDecimal value) {
        value = value.divide(BigDecimal.valueOf(Math.pow(1 + getInflationRate(), portfolio.getTerm())),
                MathContext.DECIMAL128);

        return value;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        if (portfolio == null)
            throw new NullPointerException("Portfolio can not be null.");
        this.portfolio = portfolio;
    }

    public double getInflationRate() {
        return inflationRate;
    }

    public void setInflationRate(double inflationRate) {
        this.inflationRate = inflationRate / 100;
    }

    @Override
    public String toString() {
        return "PortfolioProcessor [portfolio=" + portfolio + ", inflationRate=" + String.format("%.6f", inflationRate)
                + "]";
    }
}
