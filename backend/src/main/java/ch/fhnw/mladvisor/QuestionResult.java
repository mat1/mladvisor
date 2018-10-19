package ch.fhnw.mladvisor;

public class QuestionResult {

    private final String question;
    private final String answer;

    public QuestionResult(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
