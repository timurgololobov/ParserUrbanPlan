package org.example;

public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;
    private final String description;

    public SummaryStatistics(final double sum, final double max, final double min, final double average, final String description) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
        this.description=description;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }

    public String getDescription() {
        return description;
    }
}
