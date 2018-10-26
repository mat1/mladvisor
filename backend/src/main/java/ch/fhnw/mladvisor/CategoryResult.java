package ch.fhnw.mladvisor;

import java.util.List;

public class CategoryResult {
    private final Category category;
    private final List<CriterionResult> criterionResults;
    private final List<QuestionResult> questionResults;

    public CategoryResult(Category category,
                          List<CriterionResult> criterionResults,
                          List<QuestionResult> questionResults) {
        this.category = category;
        this.criterionResults = criterionResults;
        this.questionResults = questionResults;
    }

    public Category getCategory() {
        return category;
    }

    public List<CriterionResult> getCriterionResults() {
        return criterionResults;
    }

    public List<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public double getTotalPoints() {
        return criterionResults.stream().mapToDouble(CriterionResult::getWeightedPoints).sum();
    }

    public int getMaximumPoints() {
        return Criterion.MAXIMUM_POINTS;
    }
}
