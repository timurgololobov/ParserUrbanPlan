package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class UrbanPlanTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;
    private final String value;


    public UrbanPlanTransaction(final LocalDate date, final double amount, final String description,final String value) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.value = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UrbanPlanTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrbanPlanTransaction that = (UrbanPlanTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }


}