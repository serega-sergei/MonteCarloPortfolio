package com.personalcapital;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.personalcapital.model.PortfolioTest;
import com.personalcapital.montecarlo.MonteCarloRunnerTest;
import com.personalcapital.montecarlo.PortfolioProcessorTest;
import com.personalcapital.utils.RandomGaussianTest;

@RunWith(Suite.class)
@SuiteClasses({ 
    PortfolioTest.class, 
    MonteCarloRunnerTest.class, 
    PortfolioProcessorTest.class, 
    RandomGaussianTest.class
})
public class MonteCarloTestSuite {

}
