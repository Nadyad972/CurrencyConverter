package entities;

public class Ils extends Coin {

    private final double value = 0.28;

    @Override
    double getValue() {
        return value;
    }

    public double calculate(double value) {
        return value * getValue();
    }
}
