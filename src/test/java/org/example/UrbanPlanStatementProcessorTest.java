package org.example;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class UrbanPlanStatementProcessorTest {

    @Test
    public void shouldFilterTransactionsInFebruary() {

        final UrbanPlanTransaction februarySalary
                = new UrbanPlanTransaction(LocalDate.of(2019, Month.FEBRUARY, 14), 2_000, "Salary");

        final UrbanPlanTransaction marchRoyalties
                = new UrbanPlanTransaction(LocalDate.of(2019, Month.MARCH, 20), 500, "Royalties");

        final List<UrbanPlanTransaction> urbanPlanTransactions
                = List.of(februarySalary,
                          marchRoyalties);

        final UrbanPlanStatementProcessor urbanPlanStatementProcessor = new UrbanPlanStatementProcessor(urbanPlanTransactions);
        final List<UrbanPlanTransaction> transactions
                = urbanPlanStatementProcessor.findTransactions(new UrbanPlanTransactionIsInFebruaryAndExpensive());

        assertThat(transactions, contains(februarySalary));
        assertThat(transactions, hasSize(1));
    }


    class UrbanPlanTransactionIsInFebruaryAndExpensive implements UrbanPlanTransactionFilter {
        @Override
        public boolean test(final UrbanPlanTransaction urbanPlanTransaction) {
            return urbanPlanTransaction.getDate().getMonth() == Month.FEBRUARY && urbanPlanTransaction.getAmount() >= 1_000;
        }
    }
}