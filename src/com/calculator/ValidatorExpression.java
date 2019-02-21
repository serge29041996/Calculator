package com.calculator;

/**
 * Validator for arithmetic expression.
 */
class ValidatorExpression {
  private static final String ROMAN_NUMBERS_CHARACTERS = "IVX";
  private static final String OPERATION_CHARACTERS = "+-*/";
  private static final String[] ROMAN_NUMBERS =
      new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

  private ValidatorExpression() {}

  static ExpressionParameters readNumbersAndOperationsInExpression(String expression) {
    char[] characters = expression.toCharArray();
    ExpressionParameters expressionParameters = new ExpressionParameters(characters.length);
    StringBuilder currentArabicNumber = new StringBuilder();
    StringBuilder currentRomanNumber = new StringBuilder();
    boolean isFindErrorInExpression = false;
    for (int i = 0; i < characters.length && !isFindErrorInExpression; i++) {
      if (isArabicNumber(characters[i])) {
        if (currentArabicNumber.length() == 0) {
          expressionParameters.increaseAmountArabicNumbers();
        }
        currentArabicNumber.append(characters[i]);
        isFindErrorInExpression = !isHaveOnlyOneTypeNumber(expressionParameters);
      } else if (isRomanNumber(characters[i])){
        if (currentRomanNumber.length() == 0) {
          expressionParameters.increaseAmountRomanNumbers();
        }
        currentRomanNumber.append(characters[i]);
        isFindErrorInExpression = !isHaveOnlyOneTypeNumber(expressionParameters);
      } else if (isOperationCharacter(characters[i])){
        expressionParameters.setNewOperationsToArithmeticOperations(Character.toString(characters[i]));
        expressionParameters.increaseAmountArithmeticOperations();
        currentArabicNumber = writeArabicNumberToArray(expressionParameters, currentArabicNumber);
        currentRomanNumber = writeRomanNumberToArray(expressionParameters, currentRomanNumber);
      } else {
        System.out.println("Невідомий символ або операція: " + characters[i]);
        isFindErrorInExpression = true;
      }
    }
    return validateNumberArithmeticOperations(isFindErrorInExpression, expressionParameters,
        currentArabicNumber, currentRomanNumber);
  }

  private static boolean isArabicNumber(char c) {
    return c >= 48 && c <= 57;
  }

  private static boolean isRomanNumber(char c) {
    return ROMAN_NUMBERS_CHARACTERS.indexOf(c) != -1;
  }

  private static boolean isOperationCharacter(char c) {
    return OPERATION_CHARACTERS.indexOf(c) != -1;
  }

  private static boolean isHaveOnlyOneTypeNumber(ExpressionParameters expressionParameters) {
    return (expressionParameters.getAmountArabicNumbers() > 0 &&
        expressionParameters.getAmountRomanNumbers() == 0) ||
        (expressionParameters.getAmountArabicNumbers() == 0
            && expressionParameters.getAmountRomanNumbers() > 0);
  }

  private static ExpressionParameters validateNumberArithmeticOperations(
      boolean isFindErrorInExpression,
      ExpressionParameters expressionParameters,
      StringBuilder currentArabicNumber,
      StringBuilder currentRomanNumber) {
    if (!isFindErrorInExpression) {
      writeArabicNumberToArray(expressionParameters, currentArabicNumber);
      writeRomanNumberToArray(expressionParameters, currentRomanNumber);
      if (isValidRomanNumbers(expressionParameters)) {
        return checkNumberArithmeticOperations(expressionParameters);
      } else {
        return null;
      }
    } else {
      System.out.println("В арифметичній операції не може приймати участь два види різних чисел");
      return null;
    }
  }

  private static ExpressionParameters checkNumberArithmeticOperations(ExpressionParameters
                                                                          expressionParameters) {
    if (expressionParameters.getAmountArithmeticOperations() == 0) {
      System.out.println("Не було введено арифметичної операції");
      return null;
    } else {
      if (expressionParameters.getAmountArabicNumbers() != 0
          && expressionParameters.getAmountArabicNumbers() - 1
          != expressionParameters.getAmountArithmeticOperations()) {
        System.out.println("Було введено зайву операцію");
        return null;
      } else if (expressionParameters.getAmountRomanNumbers() != 0
          && expressionParameters.getAmountRomanNumbers() - 1
          != expressionParameters.getAmountArithmeticOperations()) {
        System.out.println("Було введено зайву операцію");
        return null;
      } else {
        return expressionParameters;
      }
    }
  }

  private static StringBuilder writeArabicNumberToArray(ExpressionParameters expressionParameters,
                                                        StringBuilder arabicNumber) {
    if (arabicNumber.length() != 0) {
      expressionParameters.setNewNumberToArabicNumbers(arabicNumber.toString());
    }
    return new StringBuilder();
  }

  private static StringBuilder writeRomanNumberToArray(ExpressionParameters expressionParameters,
                                                       StringBuilder romanNumber) {
    if (romanNumber.length() != 0) {
      expressionParameters.setNewNumberToRomanNumbers(romanNumber.toString());
    }
    return new StringBuilder();
  }

  private static boolean isValidRomanNumbers(ExpressionParameters expressionParameters) {
    int amountRomanNumbers = expressionParameters.getAmountRomanNumbers();
    if (amountRomanNumbers != 0) {
      String[] romanNumbers = expressionParameters.getRomanNumbers();
      boolean isValidRomanNumber = true;
      for (int i = 0; i < amountRomanNumbers && isValidRomanNumber; i++) {
       if (!isValidRomanNumber(romanNumbers[i])) {
         System.out.println("Введено невідоме римське число: " + romanNumbers[i]);
         isValidRomanNumber = false;
       }
      }
      return isValidRomanNumber;
    } else {
      return true;
    }
  }

  private static boolean isValidRomanNumber(String romanNumber) {
    for (int i = 0; i < ROMAN_NUMBERS.length; i++) {
      if (ROMAN_NUMBERS[i].equals(romanNumber)) {
        return true;
      }
    }
    return false;
  }
}
