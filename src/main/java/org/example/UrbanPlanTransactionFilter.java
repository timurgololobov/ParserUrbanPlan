package org.example;

@FunctionalInterface
public interface UrbanPlanTransactionFilter {
    boolean test(UrbanPlanTransaction urbanPlanTransaction);
}