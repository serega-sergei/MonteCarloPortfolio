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

    @Test
    public void setDepositTest() {
        try {
            portfolio.setDeposit(new BigDecimal(-100));
        } catch (IllegalArgumentException e) {
        }

        try {
            portfolio.setDeposit(new BigDecimal(0));
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void setTerm() {
        try {
            portfolio.setTerm(-10);
        } catch (IllegalArgumentException e) {
        }

        try {
            portfolio.setTerm(0);
        } catch (IllegalArgumentException e) {
        }
    }

}
