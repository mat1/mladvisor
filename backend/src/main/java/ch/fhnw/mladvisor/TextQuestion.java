package ch.fhnw.mladvisor;

public class TextQuestion implements Question {

    private final String reference;
    private final Category category;
    private final String question;

    public TextQuestion(String reference, Category category, String question) {
        this.reference = reference;
        this.category = category;
        this.question = question;
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
}
