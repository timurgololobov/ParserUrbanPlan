package org.example;

@FunctionalInterface
public interface UrbanPlanTransactionSummarizer {
    double summarize(double accumulator, UrbanPlanTransaction urbanPlanTransaction);
}

