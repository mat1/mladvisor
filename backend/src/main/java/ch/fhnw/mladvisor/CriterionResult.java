package ch.fhnw.mladvisor;

public class CriterionResult {
    private final double weightedPoints;
    private final Criterion criterion;

    public CriterionResult(double result, Criterion criterion) {
        this.weightedPoints = result;
        this.criterion = criterion;
    }

    public double getWeightedPoints() {
        return weightedPoints;
    }

    public Criterion getCriterion() {
        return criterion;
    }
}
