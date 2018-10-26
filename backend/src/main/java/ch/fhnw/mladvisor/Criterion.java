package ch.fhnw.mladvisor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Criterion implements Question {

    public static final int MAXIMUM_POINTS = 4;
    private final String id;
    private final String reference;
    private final Category category;
    private final SubCategory subCategory;
    private final String name;
    private final int weight;
    private final String question;
    private final boolean reverse;
    private int answer;

    public Criterion(String reference, Category category, SubCategory subCategory, String name, int weight, String question) {
        this(UUID.randomUUID().toString(), reference, category, subCategory, name, weight, question, MAXIMUM_POINTS / 2, false);
    }

    public Criterion(String reference, Category category, SubCategory subCategory, String name, int weight, String question, boolean reverse) {
        this(UUID.randomUUID().toString(), reference, category, subCategory, name, weight, question, MAXIMUM_POINTS / 2, reverse);
    }

    @JsonCreator
    public Criterion(@JsonProperty("id") String id,
                     @JsonProperty("reference") String reference,
                     @JsonProperty("category") Category category,
                     @JsonProperty("subCategory") SubCategory subCategory,
                     @JsonProperty("name") String name,
                     @JsonProperty("weight") int weight,
                     @JsonProperty("question") String question,
                     @JsonProperty("answer") int answer,
                     @JsonProperty("reverse") boolean reverse) {
        this.id = id;
        this.reference = reference;
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.weight = weight;
        this.question = question;
        this.answer = answer;
        this.reverse = reverse;
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
        return reverse ? MAXIMUM_POINTS - answer : answer;
    }

    public String toCsvString() {
        return category + ";" + subCategory + ";" + name;
    }

    public boolean isReverse() {
        return reverse;
    }
}
