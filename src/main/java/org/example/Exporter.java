package org.example;

public interface Exporter {
    String addJoining();

    String mergeArgument(String description, String value);
    String export(SummaryStatistics summaryStatistics);

}

