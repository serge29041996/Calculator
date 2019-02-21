package com.calculator;

/**
 * Class for computation with arithmetic operations.
 */
public class Computation {
  private Computation() {}

  public static void beginComputation(ExpressionParameters expressionParameters) {
    int[] numbers;
    String[] operations = expressionParameters.getArithmeticOperations();
    if (expressionParameters.isOnlyArabicNumbers()) {
      numbers = StringToIntConverter.convertArabicStringArrayToIntArray(
          expressionParameters.getArabicNumbers(),expressionParameters.getAmountArabicNumbers());
    } else {
      numbers = StringToIntConverter.convertRomanStringArrayToIntArray(
          expressionParameters.getRomanNumbers(),expressionParameters.getAmountRomanNumbers());
    }
    if (expressionParameters.getAmountArithmeticOperations() == 1) {
      System.out.println("Відповідь: " + calculate(numbers[0], numbers[1], operations[0]));
    } else {
      System.out.println("Обчислення декількох виразів не реалізовано.");
    }
  }

  static double calculate(int leftNumber, double rightNumber, String operator) {
    double result = 0;
    switch (operator) {
      case "+": result = leftNumber + rightNumber; break;
      case "-": result = leftNumber - rightNumber; break;
      case "*": result = leftNumber * rightNumber; break;
      case "/": result = (double)leftNumber / (double)rightNumber; break;
    }
    return result;
  }
}
