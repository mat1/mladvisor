package ch.fhnw.mladvisor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyControllerIT {

    @Autowired
    SurveyController surveyController;

    @Test
    public void postSurvey() {
        var survey = surveyController.createSurvey();

        var criterion = survey.getCriteria().get(0);

        SurveyResult surveyResult = surveyController.postSurvey(survey.getId(), new SurveyResultRequest(List.of(new Answer(criterion.getId(), "1"))));

        assertThat(surveyResult.getCategoryResults()).hasSize(4);
    }
}