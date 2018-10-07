package ch.fhnw.mladvisor;

import java.util.List;

public class RadioQuestion implements Question {

    private final String reference;
    private final Category category;
    private final String question;
    private final List<String> answers;

    public RadioQuestion(String reference, Category category, String question, List<String> answers) {
        this.reference = reference;
        this.category = category;
        this.question = question;
        this.answers = answers;
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
}
