package org.example;

public class MainApplication {

    public static void main(final String[] args) throws Exception {

        //Описание применяемых регулярных выражений, файл записан в CSV(путь: src/main/resources/reqexpparser.csv
        final UrbanPlanStatementParser urbanPlanStatementParser
                = new UrbanPlanStatementRegExpParser();

        //Описание анализа файла, здесь перевод pdf в txt
        final UrbanPlanStatementAnalyzer urbanPlanStatementAnalyzer
                = new UrbanPlanStatementAnalyzer();

        //Реализован перевод в строку с разметкой HTML, можно реализовать в json, xml и т.п.
        final Exporter exporter = new HtmlExporter();

        //Принимает три параметра, наименование файла, парсер с pdf и экспорт в требуемый формат
        String export = urbanPlanStatementAnalyzer.analyze("RU77101000-040954-ГПЗУ.pdf", urbanPlanStatementParser, exporter);

        //Записать HTML итоговый результат парсинга в файл по пути ресурса
        WorkWithFile.writeToFile(export);

    }
}
