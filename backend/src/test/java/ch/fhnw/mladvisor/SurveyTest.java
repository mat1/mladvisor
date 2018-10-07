package ch.fhnw.mladvisor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SurveyTest {

    @Test
    public void getCriteria() {
        Survey survey = new Survey();

        assertThat(survey.getCriteria()).isNotEmpty();
    }
}