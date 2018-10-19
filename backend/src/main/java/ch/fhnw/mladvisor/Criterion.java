package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Criterion implements Question {

    private final String id;
    private final String reference;
    private final Category category;
    private final SubCategory subCategory;
    private final String name;
    private final int weight;
    private final String question;
    private int answer = 2;


    public Criterion(String reference, Category category, SubCategory subCategory, String name, int weight, String question) {
        this(UUID.randomUUID().toString(), reference, category, subCategory, name, weight, question, 2);
    }

    @JsonCreator
    public Criterion(@JsonProperty("id") String id,
                     @JsonProperty("reference") String reference,
                     @JsonProperty("category") Category category,
                     @JsonProperty("subCategory") SubCategory subCategory,
                     @JsonProperty("name") String name,
                     @JsonProperty("weight") int weight,
                     @JsonProperty("question") String question,
                     @JsonProperty("answer") int answer) {
        this.id = id;
        this.reference = reference;
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.weight = weight;
        this.question = question;
        this.answer = answer;
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

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public void setAnswer(String answer) {
        if (answer == null) {
            return;
        }
        this.answer = Integer.parseInt(answer);
    }

    public String getAnswer() {
        return String.valueOf(answer);
    }

    public int getPoints() {
        return answer;
    }

    public String toCsvString() {
        return category + ";" + subCategory + ";" + name;
    }
}
