package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type")
public interface Question {
    String getId();
    String getQuestion();
    Category getCategory();
    String getAnswer();
    void setAnswer(String answer);
}
