package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Main calculator = new Main();
        Scanner scanner = new Scanner(System.in);
        double d_number1, d_number2;
        int i_number1;
        System.out.println("Press Enter key to start the application\n");
        scanner.nextLine();

        do {
            System.out.println("Calculator-DevOps, Choose to perform operation");
            System.out.print(
                    "Enter 1 to find Factorial\n" +
                            "Enter 2 to find Square Root\n" +
                            "Enter 3 to find Power\n" +
                            "Enter 4 to find Natural Logarithm\n" +
                            "Enter any other input to Exit\n" +
                            "Enter your choice: "
            );

            int choice;

            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException error) {
                System.out.println("Exiting....");
                scanner.close();
                return;
            }

            switch (choice) {
                case 1:
                    i_number1 = -1;
                    while (i_number1 < 0) {
                        try {
                            System.out.print("Enter a non-negative integer : ");
                            i_number1 = scanner.nextInt();

                            if (i_number1 < 0)
                                System.out.println("Factorial is only applicable for non-negative integers");
                            else
                                System.out.println("Factorial of " + i_number1 + " is: " + calculator.factorial(i_number1) + "\n");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Factorial is only applicable for non-negative integers");
                        }
                        scanner.nextLine();
                    }

                    break;

                case 2:
                    d_number1 = -1;
                    while (d_number1 < 0) {
                        try {
                            System.out.print("Enter a non-negative number: ");
                            d_number1 = scanner.nextDouble();

                            if (d_number1 < 0)
                                System.out.println("Square Root is only applicable for non-negative numbers");
                            else
                                System.out.println("Square Root of " + d_number1 + " is: " + calculator.squareRoot(d_number1) + "\n");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Square Root is only applicable for non-negative numbers");
                        }
                        scanner.nextLine();
                    }

                    break;

                case 3:
                    d_number1 = Double.POSITIVE_INFINITY; d_number2 = Double.POSITIVE_INFINITY;
                    while (d_number1 == Double.POSITIVE_INFINITY) {
                        try {
                            System.out.print("Enter the first number: ");
                            d_number1 = scanner.nextDouble();
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Non-numeric input is not valid");
                        }
                        scanner.nextLine();
                    }
                    while (d_number2 == Double.POSITIVE_INFINITY) {
                        try {
                            System.out.print("Enter the second number: ");
                            d_number2 = scanner.nextDouble();
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Non-numeric input is not valid");
                        }
                        scanner.nextLine();
                    }

                    System.out.println(d_number1 + " raised to " + d_number2 + " is: " + calculator.power(d_number1, d_number2));
                    System.out.println("\n");
                    break;

                case 4:
                    d_number1 = 0;
                    while (d_number1 <= 0) {
                        try {
                            System.out.print("Enter a positive number: ");
                            d_number1 = scanner.nextDouble();

                            if (d_number1 <= 0)
                                System.out.println("Natural Logarithm is only applicable for positive numbers");
                            else
                                System.out.println("Natural Logarithm of " + d_number1 + " is: " + calculator.naturalLog(d_number1) + "\n");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Natural Logarithm is only applicable for positive numbers");
                        }
                        scanner.nextLine();
                    }

                    break;

                default:
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
            }
        } while (true);
    }

    public int factorial(int number1) {
        logger.info("[FACTORIAL] - " + number1);

        int result = 1;
        for(int i = 1; i <= number1; i++)
            result *= i;

        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }

    public double squareRoot(double number1) {
        logger.info("[SQ ROOT] - " + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }

    public double power(double number1, double number2) {
        logger.info("[POWER - " + number1 + " RAISED TO] " + number2);
        double result = Math.pow(number1,number2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double number1) {
        logger.info("[NATURAL LOG] - " + number1);
        double result = 0;

        try {
            if (number1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else
                result = Math.log(number1);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }

}
