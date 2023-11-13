package validators;

public class DoubleValidator implements Validator<Double> {
    @Override
    public boolean validate(Double value) {
        return value != null && value > 0;
    }
}