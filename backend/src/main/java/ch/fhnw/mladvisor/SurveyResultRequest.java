package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SurveyResultRequest {

    private final List<Answer> answers;

    @JsonCreator
    public SurveyResultRequest(@JsonProperty("answers") List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
