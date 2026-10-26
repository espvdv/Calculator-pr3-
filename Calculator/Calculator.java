public class Calculator {

    private void validateNumbers(double a, double b) throws InvalidInputException {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new InvalidInputException("Числа не можуть бути NaN");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new InvalidInputException("Числа не можуть бути нескінченними");
        }
    }

    public double add(double a, double b) throws InvalidInputException {
        validateNumbers(a, b);
        return a + b;
    }

    public double subtract(double a, double b) throws InvalidInputException {
        validateNumbers(a, b);
        return a - b;
    }

    public double multiply(double a, double b) throws InvalidInputException {
        validateNumbers(a, b);
        return a * b;
    }

    public double divide(double a, double b) throws InvalidInputException {
        validateNumbers(a, b);
        if (b == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе!");
        }
        return a / b;
    }
}