package ch.fhnw.mladvisor;

import org.assertj.core.data.Offset;
import org.junit.Test;

import java.util.List;

import static ch.fhnw.mladvisor.Category.INPUT;
import static ch.fhnw.mladvisor.SubCategory.DATA_QUANTITY;
import static org.assertj.core.api.Assertions.assertThat;

public class SurveyEvaluatorTest {

    @Test
    public void getResult() {
        List<Question> questions = List.of(
                createCriterion(INPUT, "Available data", 3),
                createCriterion(INPUT, "Clean data", 1)
        );

        var survey = new Survey("id", questions);

        survey.getQuestions().forEach(q -> q.setAnswer("1"));

        SurveyResult result = SurveyEvaluator.getResult(survey);

        assertThat(result.getCategoryResults()).hasSize(1);
        assertThat(result.getCategoryResults().get(0).getCriterionResults()).hasSize(2);
        assertThat(result.getCategoryResults().get(0).getCriterionResults().get(0).getWeightedPoints()).isEqualTo(0.75);
        assertThat(result.getCategoryResults().get(0).getCriterionResults().get(1).getWeightedPoints()).isEqualTo(0.25);
    }

    @Test
    public void getTotalPoints() {
        List<Question> questions = List.of(
                createCriterion(INPUT, "Available data", 3),
                createCriterion(INPUT, "Clean data", 1)
        );

        var survey = new Survey("id", questions);

        survey.getQuestions().forEach(q -> q.setAnswer("4"));

        SurveyResult result = SurveyEvaluator.getResult(survey);

        assertThat(result.getCategoryResults()).hasSize(1);
        assertThat(result.getCategoryResults().get(0).getTotalPoints()).isEqualTo(4);
    }

    private Criterion createCriterion(Category category, String name, int weight) {
        return new Criterion("F1", category, DATA_QUANTITY, name, weight, "It is enough labeled data available.");
    }
}