package ch.fhnw.mladvisor;

import java.util.UUID;

public class Criterion implements Question {

    private final String id = UUID.randomUUID().toString();
    private final String reference;
    private final Category category;
    private final SubCategory subCategory;
    private final String name;
    private final int weight;
    private final String question;
    private int answer;

    public Criterion(String reference, Category category, SubCategory subCategory, String name, int weight, String question) {
        this.reference = reference;
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.weight = weight;
        this.question = question;
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

    public int getPoints() {
        return answer;
    }

    public String toCsvString() {
        return category + ";" + subCategory + ";" + name;
    }
}
