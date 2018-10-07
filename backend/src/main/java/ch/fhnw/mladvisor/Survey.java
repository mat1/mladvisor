package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.UUID;

import static ch.fhnw.mladvisor.Category.*;
import static ch.fhnw.mladvisor.SubCategory.*;
import static java.util.stream.Collectors.toList;

public class Survey {

    private final String id = UUID.randomUUID().toString();

    private List<Question> questions = List.of(
            new TextQuestion("F1", GENERAL, "Please describe the problem, the customer wants to solve in a few sentence."),
            new Criterion("F1", INPUT, DATA_QUANTITY, "Available labeled data", 1, "It is enough labeled data available."),
            new Criterion("F1", INPUT, DATA_QUANTITY, "Cost for collecting data compared with benefit", 1, "Cost for collecting data compared with benefit is low."),
            new Criterion("F1", INPUT, DATA_QUANTITY, "Cost for labeling data compared with benefit", 1, "Cost for labeling data compared with benefit is low."),
            new TextQuestion("F1", INPUT, "How was the data labeled?"),
            new Criterion("F1", INPUT, DATA_QUALITY, "Clean data", 1, "The dataset is clean."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Balanced data", 1, "The available data is balanced."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Structured data", 1, "The available data is structured."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Possibility to extend input data with additional features", 1, "Is it possible to extend the input data with additional features."),
            new Criterion("F1", INPUT, DATA_ACCESS, "Access to data without restriction", 1, "Access to the data is possible without restriction."),
            new Criterion("F1", INPUT, DATA_ACCESS, "Legal foundations for use of the data", 1, "The legal foundations for use of the data is given."),
            new RadioQuestion("F1", OUTPUT, "Which kind of output is expected?", List.of("Continuous Value (Regression)", "Class (Classification)")),
            RadioQuestion.yesNoUnkown(OUTPUT, "Are there existing rules? For example restaurant opening hours."),
            new Criterion("F1", OUTPUT, DATA_QUALITY, "Connection between input and output data" , 1, "The connection between input and output data is very random."),
            new Criterion("F1", OUTPUT, MODEL_INTERPRETABILITY, "Importance of model interpretability", 1, "It is important that the model can be interpreted."),
            new Criterion("F1", OUTPUT, null, "Cost for error in prediction", 1, "Costs for errors in prediction are low."),
            RadioQuestion.yesNoUnkown(ACTUAL, "Is there an existing model? Or some approximate rules?"),
            RadioQuestion.yesNoUnkown(ACTUAL, "Can an human expert solve this task?"),
            RadioQuestion.yesNoUnkown(ACTUAL, "Does an human expert use this data?"),
            RadioQuestion.yesNoUnkown(ACTUAL, "Is the data already used for a prediction?"),
            new Criterion("F1", ACTUAL, null, "Amount of work for a human to solve this task", 1, "The amount of work for a human to solve this task is high."),
            RadioQuestion.yesNoUnkown(ACTUAL, "Are there existing services which can be used to solve this task? e.g. Cloud Services"),
            new Criterion("F1", ACTUAL, null, "Experience with machine learning", 1, "The company has experience with machine learning."),
            new Criterion("F1", ACTUAL, null, "Availability of domain knowledge", 1, "Domain knowledge to support the project is available."),
            new Criterion("F1", ACTUAL, null, "Open to work with new technologies", 1, "Employees are open to work with new technologies."),
            new Criterion("F1", ACTUAL, null, "Regulations which forbids or makes it difficult to use machine learning", 1, "There are regulations which forbids or makes it difficult to use machine learning."),
            new Criterion("F1", ACTUAL, null, "Experience with machine learning", 1, "The company has experience with machine learning."),
            new TextQuestion("F1", ACTUAL, "What is the purpose of the model output?"),
            new TextQuestion("F1", ACTUAL, "How should the model be integrated in the current process? Which decisions will be made subsequently with the output?"),
            new TextQuestion("F1", ACTUAL, "Which platform should be used? e.g. Cloud Platforms like Amazon, Google or Internal Platforms"),
            new TextQuestion("F1", ACTUAL, "How does the lifecycle of the model look like? Technically and financially"),
            new Criterion("F1", TARGET, null, "Clear project goal", 1, "There is a clear goal for the project."),
            new Criterion("F1", TARGET, null, "Clear success factors", 1, "There are clear success factors for the project."),
            new Criterion("F1", TARGET, null, "Return on investment", 1, "The return on investment is high.")
            );

    public Survey() {
    }

    Survey(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getId() {
        return id;
    }

    @JsonIgnore
    public List<Criterion> getCriteria() {
        return questions.stream()
                .filter(q -> q instanceof Criterion)
                .map(Criterion.class::cast)
                .collect(toList());
    }

    public void updateAnswer(Answer answer) {
        getQuestionById(answer.getId()).setAnswer(answer.getAnswer());
    }

    private Question getQuestionById(String id) {
        return questions.stream().filter(question -> question.getId().equals(id)).findFirst().get();
    }
}
