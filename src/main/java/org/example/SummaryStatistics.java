package org.example;

public class SummaryStatistics {
    private final double sum;
    private final double average;
    private final String description;

    public SummaryStatistics(final double sum, final double average, final String description) {
        this.sum = sum;
        this.average = average;
        this.description=description;
    }

    public double getSum() {
        return sum;
    }
    public double getAverage() {
        return average;
    }

    public String getDescription() {
        return description;
    }
}
