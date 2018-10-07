package ch.fhnw.mladvisor;

import java.util.UUID;

public class SurveyResult {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
