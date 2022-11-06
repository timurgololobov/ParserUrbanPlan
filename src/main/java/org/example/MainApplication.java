package org.example;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import static org.example.Attributes.*;

public class MainApplication {

    public static void main(final String[] args) throws Exception {

        //Описание применяемых регулярных выражений, файл записан в CSV
        final UrbanPlanStatementParser urbanPlanStatementParser
                = new UrbanPlanStatementRegExpParser();

        //Описание анализа файла, здесь перевод pdf в txt
        final UrbanPlanStatementAnalyzer urbanPlanStatementAnalyzer
                = new UrbanPlanStatementAnalyzer();

        //Реализован перевод в строку с разметкой HTML, можно реализовать в json, xml и т.п.
        final Exporter exporter = new HtmlExporter();

        //Принимает три параметра, наименование файла, парсер с pdf и экспорт в требуемый формат
        String exportHTML = urbanPlanStatementAnalyzer.analyze("example.pdf", urbanPlanStatementParser, exporter, RESOURCES);

        //Записать HTML итоговый результат парсинга в файл по пути ресурса
        try {
            final Path pathForText = Paths.get(RESOURCES + "test.html"); //добавил
            byte[] bs = exportHTML.getBytes();
            Path writtenFilePath = Files.write(pathForText, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
