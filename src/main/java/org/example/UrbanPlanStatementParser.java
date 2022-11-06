package org.example;

import java.util.List;

public interface UrbanPlanStatementParser {
    UrbanPlanTransaction parseFrom(String line);
    List<UrbanPlanTransaction> parseLinesFrom(List<String> lines, String text);
}
