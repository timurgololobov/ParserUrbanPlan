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
        final String[] columns = line.split(";");
        Pattern pattern = Pattern.compile(columns[1]);
        Matcher matcher = pattern.matcher(this.text);
        String outText;
        if(matcher.find()) {
            outText = matcher.group(1);
        } else {
            outText="не найден";
        }
        //TODO: Добавить параметр указывающий нашел выражение или нет, добавить условие, добавить дату

        return new UrbanPlanTransaction(this.amount, columns[0], outText);
    }

    public List<UrbanPlanTransaction> parseLinesFrom(final List<String> lines, final String text) {
        this.handler(text);
        return lines.stream().map(x->this.parseFrom(x)).collect(toList());
    }
}
