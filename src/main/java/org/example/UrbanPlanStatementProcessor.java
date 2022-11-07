package org.example;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class UrbanPlanStatementProcessor {

    private final List<UrbanPlanTransaction> urbanPlanTransactions;

    public UrbanPlanStatementProcessor(final List<UrbanPlanTransaction> urbanPlanTransactions) {
        this.urbanPlanTransactions = urbanPlanTransactions;
    }
    public SummaryStatistics summarizeTransactions() {

        final String description=urbanPlanTransactions.stream().map(x->x.toString()).collect(Collectors.joining("<hr>"));
//        final String value=urbanPlanTransactions.stream().map(x->x.getDescription()).collect(Collectors.joining(""));

        final DoubleSummaryStatistics doubleSummaryStatistics = urbanPlanTransactions.stream()
                .mapToDouble(UrbanPlanTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                                     doubleSummaryStatistics.getAverage(),
                                     description);
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
