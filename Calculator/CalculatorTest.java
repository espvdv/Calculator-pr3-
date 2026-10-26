public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int passed = 0, failed = 0;

        try {
            double r = calc.add(2, 3);
            check(r == 5, "Додавання 2+3=5", ++passed, failed);
        } catch (Exception e) { failed++; }

        try {
            double r = calc.subtract(10, 4);
            check(r == 6, "Віднімання 10-4=6", passed, failed);
        } catch (Exception e) { failed++; }

        try {
            double r = calc.multiply(3, 4);
            check(r == 12, "Множення 3*4=12", passed, failed);
        } catch (Exception e) { failed++; }

        try {
            double r = calc.divide(10, 2);
            check(r == 5, "Ділення 10/2=5", passed, failed);
        } catch (Exception e) { failed++; }

        try {
            calc.divide(5, 0);
            System.out.println("FAIL: очікувалось ArithmeticException");
            failed++;
        } catch (ArithmeticException e) {
            System.out.println("PASS: ділення на нуль -> " + e.getMessage());
            passed++;
        } catch (Exception e) {
            System.out.println("FAIL: очікувалось ArithmeticException");
            failed++;
        }

        try {
            calc.add(Double.NaN, 5);
            System.out.println("FAIL: очікувалось InvalidInputException");
            failed++;
        } catch (InvalidInputException e) {
            System.out.println("PASS: NaN -> " + e.getMessage());
            passed++;
        }

        try {
            calc.multiply(Double.POSITIVE_INFINITY, 2);
            System.out.println("FAIL: очікувалось InvalidInputException");
            failed++;
        } catch (InvalidInputException e) {
            System.out.println("PASS: Infinity -> " + e.getMessage());
            passed++;
        }

        System.out.println("\nРезультат: passed=" + passed + ", failed=" + failed);
    }

    private static void check(boolean cond, String name, int passed, int failed) {
        if (cond) System.out.println("PASS: " + name);
        else System.out.println("FAIL: " + name);
    }
}