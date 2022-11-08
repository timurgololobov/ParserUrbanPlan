package org.example;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class UrbanPlanStatementProcessor {

    private final List<UrbanPlanTransaction> urbanPlanTransactions;
    private final String JOINING;

    public UrbanPlanStatementProcessor(final List<UrbanPlanTransaction> urbanPlanTransactions, String JOINING) {
        this.urbanPlanTransactions = urbanPlanTransactions;
        this.JOINING = JOINING;
    }

     public SummaryStatistics summarizeTransactions() {

        final String resultForExport=urbanPlanTransactions.stream().map(x->x.toString()).collect(Collectors.joining(JOINING));

        final DoubleSummaryStatistics doubleSummaryStatistics = urbanPlanTransactions.stream()
                .mapToDouble(UrbanPlanTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                                     doubleSummaryStatistics.getAverage(),
                                     resultForExport);
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
