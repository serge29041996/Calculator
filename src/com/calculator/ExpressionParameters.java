package com.calculator;

/**
 * Class for saving arabic numbers, roman numbers and arithmetic operations.
 */
public class ExpressionParameters {
  private int amountArabicNumbers;
  private int amountRomanNumbers;
  private int amountArithmeticOperations;

  private String[] arabicNumbers;
  private String[] romanNumbers;
  private String[] arithmeticOperations;

  ExpressionParameters(int numberElementsInExpression) {
    this.amountArabicNumbers = 0;
    this.amountRomanNumbers = 0;
    this.amountArithmeticOperations = 0;
    int maxNumberElementsInExpression = (numberElementsInExpression / 2) + 1;
    this.arabicNumbers = new String[maxNumberElementsInExpression];
    this.romanNumbers = new String[maxNumberElementsInExpression];
    this.arithmeticOperations = new String[maxNumberElementsInExpression];
  }

  int getAmountArabicNumbers() {
    return amountArabicNumbers;
  }

  void increaseAmountArabicNumbers() {
    this.amountArabicNumbers++;
  }

  int getAmountRomanNumbers() {
    return amountRomanNumbers;
  }

  void increaseAmountRomanNumbers() {
    this.amountRomanNumbers++;
  }

  int getAmountArithmeticOperations() {
    return amountArithmeticOperations;
  }

  void increaseAmountArithmeticOperations() {
    this.amountArithmeticOperations++;
  }

  String[] getArabicNumbers() {
    return arabicNumbers;
  }

  void setNewNumberToArabicNumbers(String newArabicNumber) {
    this.arabicNumbers[amountArabicNumbers - 1] = newArabicNumber;
  }

  String[] getRomanNumbers() {
    return romanNumbers;
  }

  void setNewNumberToRomanNumbers(String newRomanNumber) {
    this.romanNumbers[amountRomanNumbers - 1] = newRomanNumber;
  }

  public String[] getArithmeticOperations() {
    return arithmeticOperations;
  }

  void setNewOperationsToArithmeticOperations(String newArithmeticOperations) {
    this.arithmeticOperations[amountArithmeticOperations] = newArithmeticOperations;
  }

  boolean isOnlyArabicNumbers() {
    return this.amountArabicNumbers > 0;
  }

  public boolean isOnlyRomanNumbers() {
    return this.amountRomanNumbers > 0;
  }
}
