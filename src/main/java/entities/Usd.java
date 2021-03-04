package entities;

public class Usd extends Coin {

    private final double value = 3.52;

    @Override
    double getValue() {
        return value;
    }

    public double calculate(double value) {
        return value * getValue();
    }
}
