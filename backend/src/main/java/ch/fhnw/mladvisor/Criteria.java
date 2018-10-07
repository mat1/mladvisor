package ch.fhnw.mladvisor;

import java.util.List;

import static ch.fhnw.mladvisor.Category.*;
import static ch.fhnw.mladvisor.SubCategory.*;

public class Criteria {

    List<Criterion> criterias = List.of(
            new Criterion("F1", INPUT, DATA_QUANTITY, "Available labeled data", 1, "It is enough labeled data available."),
            new Criterion("F1", INPUT, DATA_QUANTITY, "Cost for collecting data compared with benefit", 1, "Cost for collecting data compared with benefit is low."),
            new Criterion("F1", INPUT, DATA_QUANTITY, "Cost for labeling data compared with benefit", 1, "Cost for labeling data compared with benefit is low."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Clean data", 1, "The dataset is clean."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Balanced data", 1, "The available data is balanced."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Structured data", 1, "The available data is structured."),
            new Criterion("F1", INPUT, DATA_QUALITY, "Possibility to extend input data with additional features", 1, "Is it possible to extend the input data with additional features."),
            new Criterion("F1", INPUT, DATA_ACCESS, "Access to data without restriction", 1, "Access to the data is possible without restriction."),
            new Criterion("F1", INPUT, DATA_ACCESS, "Legal foundations for use of the data", 1, "The legal foundations for use of the data is given."),
            new Criterion("F1", OUTPUT, DATA_QUALITY, "Connection between input and output data" , 1, "The connection between input and output data is very random."),
            new Criterion("F1", OUTPUT, MODEL_INTERPRETABILITY, "Importance of model interpretability", 1, "It is important that the model can be interpreted."),
            new Criterion("F1", OUTPUT, null, "Cost for error in prediction", 1, "Costs for errors in prediction are low."),
            new Criterion("F1", ACTUAL, null, "Amount of work for a human to solve this task", 1, "The amount of work for a human to solve this task is high."),
            new Criterion("F1", ACTUAL, null, "Experience with machine learning", 1, "The company has experience with machine learning."),
            new Criterion("F1", ACTUAL, null, "Availability of domain knowledge", 1, "Domain knowledge to support the project is available."),
            new Criterion("F1", ACTUAL, null, "Open to work with new technologies", 1, "Employees are open to work with new technologies."),
            new Criterion("F1", ACTUAL, null, "Regulations which forbids or makes it difficult to use machine learning", 1, "There are regulations which forbids or makes it difficult to use machine learning."),
            new Criterion("F1", ACTUAL, null, "Experience with machine learning", 1, "The company has experience with machine learning."),
            new Criterion("F1", TARGET, null, "Clear project goal", 1, "There is a clear goal for the project."),
            new Criterion("F1", TARGET, null, "Clear success factors", 1, "There are clear success factors for the project."),
            new Criterion("F1", TARGET, null, "Return on investment", 1, "The return on investment is high.")
            );
}
