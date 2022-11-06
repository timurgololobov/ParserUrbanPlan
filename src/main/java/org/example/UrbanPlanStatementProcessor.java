package org.example;

import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class UrbanPlanStatementProcessor {

    private final List<UrbanPlanTransaction> urbanPlanTransactions;

    public UrbanPlanStatementProcessor(final List<UrbanPlanTransaction> urbanPlanTransactions) {
        this.urbanPlanTransactions = urbanPlanTransactions;
    }

    public SummaryStatistics summarizeTransactions() {

        final DoubleSummaryStatistics doubleSummaryStatistics = urbanPlanTransactions.stream()
                .mapToDouble(UrbanPlanTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                                     doubleSummaryStatistics.getMax(),
                                     doubleSummaryStatistics.getMin(),
                                     doubleSummaryStatistics.getAverage());
    }

    public double summarizeTransactions(final UrbanPlanTransactionSummarizer urbanPlanTransactionSummarizer) {
        double result = 0;
        for (final UrbanPlanTransaction urbanPlanTransaction : urbanPlanTransactions) {
            result = urbanPlanTransactionSummarizer.summarize(result, urbanPlanTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, urbanPlanTransaction) ->
                urbanPlanTransaction.getDate().getMonth() == month ? acc + urbanPlanTransaction.getAmount() : acc);
    }

    public List<UrbanPlanTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(urbanPlanTransaction -> urbanPlanTransaction.getAmount() >= amount);
    }

    public List<UrbanPlanTransaction> findTransactions(final UrbanPlanTransactionFilter urbanPlanTransactionFilter) {
        final List<UrbanPlanTransaction> result = new ArrayList<>();
        for (final UrbanPlanTransaction urbanPlanTransaction : urbanPlanTransactions) {
            if (urbanPlanTransactionFilter.test(urbanPlanTransaction)) {
                result.add(urbanPlanTransaction);
            }
        }
        return result;
    }
}
