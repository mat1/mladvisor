package ch.fhnw.mladvisor;

import java.util.List;

public class CategoryResult {
    private final Category category;
    private final List<CriterionResult> criterionResults;

    public CategoryResult(Category category, List<CriterionResult> criterionResults) {
        this.category = category;
        this.criterionResults = criterionResults;
    }

    public Category getCategory() {
        return category;
    }

    public List<CriterionResult> getCriterionResults() {
        return criterionResults;
    }

    public double getTotalPoints() {
        return criterionResults.stream().mapToDouble(CriterionResult::getWeightedPoints).sum();
    }

    public double getMaximumPoints() {
        return 4;
    }
}
