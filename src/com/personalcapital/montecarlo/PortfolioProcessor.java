package com.personalcapital.montecarlo;

import java.math.BigDecimal;
import java.math.MathContext;

import com.personalcapital.model.Portfolio;
import com.personalcapital.utils.RandomGaussian;

public class PortfolioProcessor implements MonteCarlo {
    private Portfolio portfolio;
    private RandomGaussian gaussian;

    public PortfolioProcessor(Portfolio portfolio) {
        super();
        if (portfolio == null)
            throw new NullPointerException();

        this.portfolio = portfolio;
        gaussian = new RandomGaussian(portfolio.getMean(), portfolio.getSd());
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
        deposit = deposit.multiply(BigDecimal.valueOf(1 + gaussian.getGaussian()), MathContext.DECIMAL128);

        return deposit;
    }

    private BigDecimal inflationAdj(BigDecimal value) {
        value = value.divide(BigDecimal.valueOf(Math.pow(1 + portfolio.getInflationRate(), portfolio.getTerm())),
                MathContext.DECIMAL128);

        return value;
    }

}
