package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class UrbanPlanStatementRegExpParser implements UrbanPlanStatementParser {

    private static String text = "";
    public static Integer amount= 1;
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void handler(String text) {
        this.text = text;
    }

    public UrbanPlanTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");
        //Описать функции регулярных выражений
        ///(?<=Площадь земельного участка \n)[0-9]{3,10}(?= кв\.м)/ig
        final String regexone = "Площадь земельного участка \n";
//        final String regextwo = "кв";
        Pattern pattern = Pattern.compile(columns[1]);
        Matcher matcher = pattern.matcher(this.text);
        String outText;
        if(matcher.find()) {
            outText = this.text.substring(matcher.start(), matcher.end());
        } else {
            outText="Тестовая запись";
        }
        //TODO: Добавить параметр указывающий нашел выражение или нет, добавить условие

        //final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        //final double amount = Double.parseDouble(columns[1]);
        return new UrbanPlanTransaction(this.amount, columns[0], outText);
    }

    public List<UrbanPlanTransaction> parseLinesFrom(final List<String> lines, final String text) {
        this.handler(text);
        return lines.stream().map(x->this.parseFrom(x)).collect(toList());
    }
}
