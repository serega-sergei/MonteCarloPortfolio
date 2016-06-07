package com.personalcapital;

import java.math.BigDecimal;

import com.personalcapital.model.Portfolio;
import com.personalcapital.montecarlo.MonteCarloRunner;
import com.personalcapital.montecarlo.PortfolioProcessor;

public class MCTest {
    private static final int ITER_NUM = 10000;
    private static final Portfolio AGRESSIVE = new Portfolio(BigDecimal.valueOf(100000), 20, 9.4324, 15.675, 3.5);
    private static final Portfolio CONSERVATIVE = new Portfolio(BigDecimal.valueOf(100000), 20, 6.189, 6.3438, 3.5);
    private static final Portfolio PERSONAL_CAPITAL_TEST = new Portfolio(BigDecimal.valueOf(100000), 20, 8.9, 14.5,
            3.9);

    public static void main(String[] args) {
        MonteCarloRunner runnerAgressive = new MonteCarloRunner(ITER_NUM, new PortfolioProcessor(AGRESSIVE));
        MonteCarloRunner runnerConservative = new MonteCarloRunner(ITER_NUM, new PortfolioProcessor(CONSERVATIVE));
        MonteCarloRunner runnerPersonalCapitalTest = new MonteCarloRunner(ITER_NUM,
                new PortfolioProcessor(PERSONAL_CAPITAL_TEST));

        System.out.println("Aggressive Portfolio: ");
        runnerAgressive.runSimulation();
        runnerAgressive.printResults(System.out);

        System.out.println("\nConservative Portfolio: ");
        runnerConservative.runSimulation();
        runnerConservative.printResults(System.out);

        System.out.println("\nPersonal Capital Test Portfolio: ");
        runnerPersonalCapitalTest.runSimulation();
        runnerPersonalCapitalTest.printResults(System.out);

    }

}
