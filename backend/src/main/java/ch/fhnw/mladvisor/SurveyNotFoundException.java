package ch.fhnw.mladvisor;

public class SurveyNotFoundException extends RuntimeException {
    public SurveyNotFoundException(String id) {
        super("No survey found with id=" + id);
    }
}
