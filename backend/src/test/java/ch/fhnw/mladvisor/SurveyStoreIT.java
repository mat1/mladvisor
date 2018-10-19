package ch.fhnw.mladvisor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyStoreIT {

    @Autowired
    SurveyStore surveyStore;

    @Test
    public void saveSurvey() {
        var survey = new Survey();
        surveyStore.saveSurvey(survey);
    }

    @Test
    public void getSurveyById() {
        var survey = new Survey();
        surveyStore.saveSurvey(survey);
        Survey result = surveyStore.getSurveyById(survey.getId());

        assertThat(result.getId()).isEqualTo(survey.getId());
        assertThat(result.getCriteria().size()).isEqualTo(survey.getCriteria().size());
        assertThat(result.getQuestions().size()).isEqualTo(survey.getQuestions().size());
    }

    @Test(expected = SurveyNotFoundException.class)
    public void getSurveyById_notExisting() {
        Survey result = surveyStore.getSurveyById("notExisting");
    }

    @Test
    public void updateSurvey() {
        var survey = new Survey();
        surveyStore.saveSurvey(survey);

        Criterion criterion = survey.getCriteria().get(0);
        survey.updateAnswer(new Answer(criterion.getId(), "2"));

        surveyStore.updateSurvey(survey);
    }
}