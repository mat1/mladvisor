package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonSubTypes.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = TextQuestion.class),
        @Type(value = RadioQuestion.class),
        @Type(value = Criterion.class)
})
public interface Question {
    String getId();

    String getQuestion();

    Category getCategory();

    String getAnswer();

    void setAnswer(String answer);
}
