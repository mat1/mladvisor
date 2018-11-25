package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

import static ch.fhnw.mladvisor.Category.*;
import static ch.fhnw.mladvisor.SubCategory.*;
import static java.util.stream.Collectors.toList;

public class Survey {

    private final String id;

    private List<Question> questions = List.of(
            new TextQuestion("F1", GENERAL,
                    "Please describe the problem, the customer wants to solve in a few sentences."),

            RadioQuestion.yesNoUnkown(ACTUAL,
                    "Is there an existing model? Or some approximate rules?"),
            RadioQuestion.yesNoUnkown(ACTUAL,
                    "Is the data already used for a prediction?"),
            RadioQuestion.yesNoUnkown(ACTUAL,
                    "Can a human expert solve this task?"),
            RadioQuestion.yesNoUnkown(ACTUAL,
                    "Does a human expert use this data?"),
            new Criterion("F1", ACTUAL, null,
                    "Amount of work for a human to solve this task", 2.2, "The amount of work for a human to solve this task is high."),
            new Criterion("F1", ACTUAL, null,
                    "Open to work with new technologies", 2.2, "Employees are open to work with new technologies."),
            new Criterion("F1", ACTUAL, null,
                    "Experience with machine learning", 1.8, "The company has experience with machine learning."),
            new Criterion("F1", ACTUAL, null,
                    "Availability of domain knowledge", 2.8, "Domain knowledge to support the project is available."),
            new Criterion("F1", ACTUAL, null,
                    "Regulations which forbids or makes it difficult to use machine learning", 3, "There are regulations which forbids or makes it difficult to use machine learning."),
            new TextQuestion("F1", ACTUAL,
                    "How should the model be integrated in the current process? Which decisions will be made subsequently with the output?"),
            new TextQuestion("F1", ACTUAL,
                    "Which platform should be used? e.g. Cloud Platforms like Amazon, Google or Internal Platforms"),
            RadioQuestion.yesNoUnkown(ACTUAL,
                    "Are there existing services which can be used to solve this task? e.g. Cloud Services"),
            new TextQuestion("F1", ACTUAL,
                    "How does the lifecycle of the model look like? Technically and financially"),

            new Criterion("F1", TARGET, null,
                    "Clear project goal", 2.4, "There is a clear goal for the project."),
            new Criterion("F1", TARGET, null,
                    "Clear success factors", 2.2, "There are clear success factors for the project."),
            new Criterion("F1", TARGET, null,
                    "Return on investment", 2, "The return on investment is high."),

            new TextQuestion("F1", OUTPUT,
                    "What is the purpose of the model output?"),
            new RadioQuestion("F1", OUTPUT,
                    "Which kind of output is expected?", List.of("Continuous Value (Regression)", "Class (Classification)")),
            RadioQuestion.yesNoUnkown(OUTPUT,
                    "Are there existing rules, which should be considered for the model?"),
            new Criterion("F1", OUTPUT, DATA_QUALITY,
                    "Randomness in connection between input and output data" , 2, "The connection between input and output data is very random.", true),
            new Criterion("F1", OUTPUT, MODEL_INTERPRETABILITY,
                    "Importance of model interpretability", 2.2, "It is important that the model can be interpreted.", true),
            new Criterion("F1", OUTPUT, null, "Cost for error in prediction", 2.2, "Costs for errors in prediction are low."),

            new Criterion("F1", INPUT, DATA_QUANTITY,
                    "Amount of available labeled data", 2.2, "Enough labeled data is available."),
            new Criterion("F1", INPUT, DATA_QUANTITY,
                    "Cost for collecting data compared with benefit", 2.6, "Cost for collecting data compared with benefit is low."),
            new Criterion("F1", INPUT, DATA_QUANTITY,
                    "Cost for labeling data compared with benefit", 2.6, "Cost for labeling data compared with benefit is low."),
            new TextQuestion("F1", INPUT,
                    "How was the data labeled?"),
            new Criterion("F1", INPUT, DATA_QUALITY,
                    "Clean data", 2, "The dataset is clean."),
            new Criterion("F1", INPUT, DATA_QUALITY,
                    "Balanced data", 2, "The available data is balanced."),
            new Criterion("F1", INPUT, DATA_QUALITY,
                    "Structured data", 2, "The available data is structured."),
            new Criterion("F1", INPUT, DATA_QUALITY,
                    "Possibility to extend input data with additional features", 1, "It is possible to extend the input data with additional features."),
            new Criterion("F1", INPUT, DATA_ACCESS,
                    "Access to data without restriction", 2.4, "Access to the data is possible without restriction."),
            new Criterion("F1", INPUT, DATA_ACCESS,
                    "Legal foundations for use of the data", 3, "The legal foundations for use of the data is given.")

            );

    public Survey() {
        this.id = UUID.randomUUID().toString();
    }

    @JsonCreator
    public Survey(@JsonProperty("id") String id,
                  @JsonProperty("questions") List<Question> questions) {
        this.id = id;
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
