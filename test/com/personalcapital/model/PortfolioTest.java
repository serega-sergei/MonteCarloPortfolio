package com.personalcapital.model;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class PortfolioTest {
    private Portfolio portfolio;

    @Before
    public void setUp() {
        portfolio = new Portfolio(new BigDecimal(100), 10, 10, 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDepositTest() {
        portfolio.setDeposit(new BigDecimal(-100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTerm() {
        portfolio.setTerm(-10);
    }

}
