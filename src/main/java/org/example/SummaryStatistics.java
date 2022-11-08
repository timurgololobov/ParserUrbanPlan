package org.example;

public class SummaryStatistics {
    private final double sum;
    private final double average;
    private final String result;


    public SummaryStatistics(final double sum, final double average, final String result) {
        this.sum = sum;
        this.average = average;
        this.result=result;

    }

    public double getSum() {
        return sum;
    }
    public double getAverage() {
        return average;
    }

    public String getResult() {
        return result;
    }

}
