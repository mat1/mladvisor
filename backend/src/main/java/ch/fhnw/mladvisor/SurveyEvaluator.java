package ch.fhnw.mladvisor;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class SurveyEvaluator {

    static SurveyResult getResult(Survey survey) {
        List<CategoryResult> categoryResults = toCategoryResults(survey);

        return new SurveyResult(toQuestionResult(survey, Category.GENERAL), categoryResults);
    }

    private static List<CategoryResult> toCategoryResults(Survey survey) {
        Map<Category, List<Criterion>> criteraByCategory = survey.getCriteria().stream().collect(groupingBy(Criterion::getCategory));

        return criteraByCategory.entrySet().stream().map(entry -> {
            var category = entry.getKey();
            return new CategoryResult(category,
                    toCriterionResult(entry.getValue()),
                    toQuestionResult(survey, category));
        }).collect(toList());
    }

    private static List<QuestionResult> toQuestionResult(Survey survey, Category category) {
        return survey.getQuestions().stream()
                .filter(q -> !(q instanceof Criterion))
                .filter(q -> q.getCategory() == category && q.getAnswer() != null)
                .map(q -> new QuestionResult(q.getQuestion(), q.getAnswer()))
                .collect(toList());
    }

    private static List<CriterionResult> toCriterionResult(List<Criterion> criterion) {
        int size = criterion.size();
        double totalWeight = criterion.stream().mapToInt(Criterion::getWeight).sum();

        return criterion.stream().map(c -> {
            double result = (c.getWeight() / totalWeight) * c.getPoints();
            return new CriterionResult(result, c);
        }).collect(toList());
    }
}
