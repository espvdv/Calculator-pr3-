import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
         System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("=== Калькулятор ===");
        System.out.print("Введіть перше число: ");

        try {
            double a = scanner.nextDouble();

            System.out.print("Введіть друге число: ");
            double b = scanner.nextDouble();

            System.out.print("Введіть операцію (+, -, *, /): ");
            String operation = scanner.next();

            double result;

            switch (operation) {
                case "+":
                    result = calculator.add(a, b);
                    break;
                case "-":
                    result = calculator.subtract(a, b);
                    break;
                case "*":
                    result = calculator.multiply(a, b);
                    break;
                case "/":
                    result = calculator.divide(a, b);
                    break;
                default:
                    System.out.println("Помилка: невідома операція '" + operation + "'");
                    return;
            }

            System.out.println("Результат: " + a + " " + operation + " " + b + " = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Помилка: введено не число! Перевірте формат вводу.");
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Помилка вхідних даних: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        } finally {
            System.out.println("=== Обробку запиту завершено ===");
            scanner.close();
        }
    }
}