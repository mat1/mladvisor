package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TextQuestion implements Question {

    private final String id;
    private final String reference;
    private final Category category;
    private final String question;
    private String answer;

    public TextQuestion(String reference, Category category, String question) {
        this(UUID.randomUUID().toString(), reference, category, question, null);
    }

    @JsonCreator
    public TextQuestion(@JsonProperty("id") String id,
                        @JsonProperty("reference") String reference,
                        @JsonProperty("category") Category category,
                        @JsonProperty("question") String question,
                        @JsonProperty("answer") String answer) {
        this.id = id;
        this.reference = reference;
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
