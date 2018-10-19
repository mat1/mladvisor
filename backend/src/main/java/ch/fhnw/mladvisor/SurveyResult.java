package ch.fhnw.mladvisor;

import java.util.List;
import java.util.UUID;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class SurveyResult {

    private final String id = UUID.randomUUID().toString();
    private final List<QuestionResult> generalResults;
    private final List<CategoryResult> categoryResults;

    public SurveyResult(List<QuestionResult> generalResults, List<CategoryResult> categoryResults) {
        this.generalResults = generalResults;
        this.categoryResults = categoryResults;
    }

    public String getId() {
        return id;
    }

    public List<QuestionResult> getGeneralResults() {
        return generalResults;
    }

    public List<CategoryResult> getCategoryResults() {
        return categoryResults.stream()
                .sorted(comparing(CategoryResult::getCategory))
                .collect(toList());
    }
}
