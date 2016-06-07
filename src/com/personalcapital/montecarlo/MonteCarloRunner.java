package com.personalcapital.montecarlo;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class MonteCarloRunner {
    private BigDecimal[] values;
    private int iterationsNum;
    private MonteCarlo montecarlo;

    public MonteCarloRunner(int iterationsNum, MonteCarlo montecarlo) {
        super();
        this.values = new BigDecimal[iterationsNum];
        this.iterationsNum = iterationsNum;
        this.montecarlo = montecarlo;
    }

    public BigDecimal[] runSimulation() {
        values = new BigDecimal[10000];

        for (int i = 0; i < iterationsNum; i++) {
            values[i] = montecarlo.generateValue();
        }

        Arrays.sort(values);

        return values;
    }

    public void printResults(PrintStream out) {
        BigDecimal median, worst10, best10;

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

        out.println(montecarlo);
        out.println("Median: " + df.format(median));
        out.println("90%: " + df.format(best10));
        out.println("10%: " + df.format(worst10));

    }

}
