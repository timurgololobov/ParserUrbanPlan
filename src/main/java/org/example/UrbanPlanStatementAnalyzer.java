package org.example;

import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.example.Attributes.*;
public class UrbanPlanStatementAnalyzer {

    public String analyze(final String fileName,
                        final UrbanPlanStatementParser urbanPlanStatementParser,
                        final Exporter exporter) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final Path pathReqexp = Paths.get(RESOURCES + "regexpparser.csv");

        PDDocument document = PDDocument.load(path.toString());
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();

        final List<String> lines = Files.readAllLines(pathReqexp);

        final List<UrbanPlanTransaction> urbanPlanTransactions = urbanPlanStatementParser.parseLinesFrom(lines,text);

        final UrbanPlanStatementProcessor urbanPlanStatementProcessor = new UrbanPlanStatementProcessor(urbanPlanTransactions, exporter);

        final SummaryStatistics summaryStatistics = urbanPlanStatementProcessor.summarizeTransactions();

        return exporter.export(summaryStatistics);

    }

}
