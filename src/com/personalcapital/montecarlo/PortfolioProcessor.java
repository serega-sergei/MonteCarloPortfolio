package com.personalcapital.montecarlo;

import java.math.BigDecimal;
import java.math.MathContext;

import com.personalcapital.model.Portfolio;
import com.personalcapital.utils.RandomGaussian;

/**
 * Class for Portfolio deposit outcome generation
 * 
 * @author Siarhei Siryk
 * @see Portfolio
 */
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

    /**
     * Generate outcome for deposit after "term" years, inflation adjusted
     * 
     * @return outcome
     * @see generateNextYearValue(BigDecimal deposit)
     * @see inflationAdj(BigDecimal value)
     */
    public BigDecimal generateTermYearsValue() {
        BigDecimal res = portfolio.getDeposit();

        for (int i = 0; i < portfolio.getTerm(); i++) {
            res = generateNextYearValue(res);
        }

        return inflationAdj(res);
    }

    /**
     * Generate outcome for deposit after one year using random gaussian value
     * for return based on past risk (SD) and return (mean)
     * 
     * @param deposit
     * @return outcome
     */
    private BigDecimal generateNextYearValue(BigDecimal deposit) {
        deposit = deposit.multiply(BigDecimal.valueOf(
                1 + RandomGaussian.getGaussian(portfolio.getMean() / 100, portfolio.getStandardDeviation() / 100)),
                MathContext.DECIMAL128);

        return deposit;
    }

    /**
     * Adjust future deposit value considering inflation rate and deposit term.
     * Ie. Year 1 value of 103.5 is equivalent to 100 at Year 0.
     * 
     * @param future
     *            value
     * @return inflation adjusted value
     */
    private BigDecimal inflationAdj(BigDecimal value) {
        value = value.divide(BigDecimal.valueOf(Math.pow(1 + (getInflationRate() / 100), portfolio.getTerm())),
                MathContext.DECIMAL128);

        return value;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        if (portfolio == null)
            throw new NullPointerException("Portfolio can not be null");
        this.portfolio = portfolio;
    }

    public double getInflationRate() {
        return inflationRate;
    }

    public void setInflationRate(double inflationRate) {
        this.inflationRate = inflationRate;
    }

    @Override
    public String toString() {
        return "PortfolioProcessor [portfolio=" + portfolio + ", inflationRate=" + String.format("%.6f", inflationRate)
                + "]";
    }
}
