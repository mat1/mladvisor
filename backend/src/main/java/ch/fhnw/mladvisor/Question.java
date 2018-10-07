package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.MINIMAL_CLASS, property="type")
public interface Question {
    String getQuestion();
}
