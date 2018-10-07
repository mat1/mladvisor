package ch.fhnw.mladvisor;

import java.util.List;

public class Question {

    private final String question;
    private final List<Answer> answers;

    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public static Question likertScale() {
        return null;
    }
}
