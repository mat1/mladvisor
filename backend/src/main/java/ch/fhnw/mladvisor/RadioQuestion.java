package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class RadioQuestion implements Question {

    private final String id;
    private final String reference;
    private final Category category;
    private final String question;
    private final List<String> answers;
    private String answer;

    public RadioQuestion(String reference, Category category, String question, List<String> answers) {
        this(UUID.randomUUID().toString(), reference, category, question, answers, null);
    }

    @JsonCreator
    public RadioQuestion(@JsonProperty("id") String id,
                         @JsonProperty("reference") String reference,
                         @JsonProperty("category") Category category,
                         @JsonProperty("question") String question,
                         @JsonProperty("answers") List<String> answers,
                         @JsonProperty("answer") String answer) {
        this.id = id;
        this.reference = reference;
        this.category = category;
        this.question = question;
        this.answers = answers;
        this.answer = answer;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public Category getCategory() {
        return category;
    }

    public static RadioQuestion yesNoUnkown(Category category, String question) {
        return new RadioQuestion("F1", category, question, List.of("Yes", "No", "Unknown"));
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
