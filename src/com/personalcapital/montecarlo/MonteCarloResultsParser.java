package com.personalcapital.montecarlo;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Class for parsing Monte Carlo simulation results
 * 
 * @author Siarhei Siryk
 * @see MonteCarloRunner
 */
public class MonteCarloResultsParser {

    /**
     * Writing Monte Carlo simulation results in a provided PrintStream out for
     * corresponding MonteCarloRunner
     * 
     * @param out
     *            where to write results
     * @param monteCarloRunner
     *            to print results for
     */
    public static void printResults(PrintStream out, MonteCarloRunner monteCarloRunner) {
        BigDecimal median, worst10, best10;
        BigDecimal[] values = monteCarloRunner.getValues();

        if (values.length % 2 == 0)
            median = (values[values.length / 2].add(values[values.length / 2 - 1])).divide(new BigDecimal(2));
        else
            median = values[values.length / 2];

        worst10 = values[new Long(Math.round(values.length * 0.1)).intValue()];
        best10 = values[new Long(Math.round(values.length * 0.9)).intValue()];

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(1);
        df.setGroupingUsed(false);

        out.println(monteCarloRunner.getMontecarlo());
        out.println("Median: " + df.format(median));
        out.println("90%: " + df.format(best10));
        out.println("10%: " + df.format(worst10));
    }

}
