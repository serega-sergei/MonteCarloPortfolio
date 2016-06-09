package com.personalcapital.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

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
            assertThat(e.getMessage(), containsString("Deposit can not be nagative or zero"));
        }

        try {
            portfolio.setDeposit(new BigDecimal(0));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Deposit can not be nagative or zero"));
        }
    }

    @Test
    public void setTerm() {
        try {
            portfolio.setTerm(-10);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Term can not be nagative or zero"));
        }

        try {
            portfolio.setTerm(0);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Term can not be nagative or zero"));
        }
    }

}
