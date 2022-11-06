package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UrbanPlanStatementRegExpParser implements UrbanPlanStatementParser {

    private static String text = "";
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

//    LocalDate date = LocalDate.now();
//    String textDate = date.format(formatter);
//    LocalDate parsedDate = LocalDate.parse(textDate, formatter);
    public void handler(String text) {
        this.text = text;
    }

    public UrbanPlanTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");
        //Описать функции регулярных выражений

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        return new UrbanPlanTransaction(date, amount, columns[2], columns[2]);
    }

    public List<UrbanPlanTransaction> parseLinesFrom(final List<String> lines, final String text) {
        this.handler(text);
        return lines.stream().map(x->this.parseFrom(x)).collect(toList());
    }
}
