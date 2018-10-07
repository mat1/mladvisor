package ch.fhnw.mladvisor;

import java.util.List;
import java.util.UUID;

public class SurveyResult {

    private final String id = UUID.randomUUID().toString();
    private final List<String> generalResults;
    private final List<CategoryResult> categoryResults;

    public SurveyResult(List<String> generalResults, List<CategoryResult> categoryResults) {
        this.generalResults = generalResults;
        this.categoryResults = categoryResults;
    }

    public String getId() {
        return id;
    }

    public List<String> getGeneralResults() {
        return generalResults;
    }

    public List<CategoryResult> getCategoryResults() {
        return categoryResults;
    }
}
