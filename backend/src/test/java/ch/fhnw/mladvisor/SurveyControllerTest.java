package ch.fhnw.mladvisor;

import org.junit.Test;

import java.util.List;

public class SurveyControllerTest {

    @Test
    public void postSurvey() {
        var surveyController = new SurveyController();

        var survey = surveyController.createSurvey();

        var criterion = survey.getCriteria().get(0);

        SurveyResult surveyResult = surveyController.postSurvey(survey.getId(), new SurveyResultRequest(List.of(new Answer(criterion.getId(), "1"))));




    }
}