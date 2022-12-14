package org.example;

public class HtmlExporter implements Exporter {

    @Override
    public String addJoining() {
        return "<hr>";
    }
    @Override
    public String mergeArgument(String description, String value) {
        return description + ": " + value;
    }
    @Override
    public String export(final SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Urban Plan Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>Результаты поиска</strong>: <hr>" + summaryStatistics.getResult() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
