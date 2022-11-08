package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class UrbanPlanTransaction {

    private final Integer amount;
    private final String description;
    private final String value;


    public UrbanPlanTransaction(final Integer amount, final String description,final String value) {
        this.description = description;
        this.value = value;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return description + ": " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrbanPlanTransaction that = (UrbanPlanTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&

                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description);
    }


}