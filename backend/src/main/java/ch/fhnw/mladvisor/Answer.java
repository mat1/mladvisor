package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private final String id;
    private final String answer;

    @JsonCreator
    public Answer(@JsonProperty("id") String id,
                  @JsonProperty("answer") String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
}
