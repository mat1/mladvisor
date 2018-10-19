package ch.fhnw.mladvisor;

import java.util.UUID;

public class TextQuestion implements Question {

    private final String id = UUID.randomUUID().toString();
    private final String reference;
    private final Category category;
    private final String question;
    private String answer;

    public TextQuestion(String reference, Category category, String question) {
        this.reference = reference;
        this.category = category;
        this.question = question;
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
