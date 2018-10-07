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

    public double getWeight() {
        return weight;
    }

    public String getQuestion() {
        return question;
    }
}
