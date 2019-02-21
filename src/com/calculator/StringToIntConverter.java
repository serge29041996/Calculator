package com.calculator;

/**
 * Class-utility for converting roman and arabic numbers from String representation to integer values.
 */
class StringToIntConverter {

  private StringToIntConverter() {}

  static int[] convertArabicStringArrayToIntArray(String[] arabicNumbers, int numberArabicNumbers) {
    int[] numbers = new int[numberArabicNumbers];
    for (int i = 0; i < numberArabicNumbers; i++) {
      numbers[i] = Integer.parseInt(arabicNumbers[i]);
    }
    return numbers;
  }

  static int[] convertRomanStringArrayToIntArray(String[] romanNumbers, int numberRomanNumbers) {
    int[] numbers = new int[numberRomanNumbers];
    for (int i = 0; i < numberRomanNumbers; i++) {
      numbers[i] = convertRomanStringToInt(romanNumbers[i]);
    }
    return numbers;
  }

  private static int convertRomanStringToInt(String romanNumber) {
    char[] charactersRomanNumbers = romanNumber.toCharArray();
    int integerNumber = 0;
    for (int i = 0; i < charactersRomanNumbers.length; i++) {
      if (charactersRomanNumbers[i] == 'I') {
        integerNumber++;
      } else if (charactersRomanNumbers[i] == 'V') {
        if (i > 0 && charactersRomanNumbers[i - 1] == 'I') {
          integerNumber+=3;
        } else {
          integerNumber+=5;
        }
      } else if (charactersRomanNumbers[i] == 'X') {
        if (i > 0 && charactersRomanNumbers[i - 1] == 'I') {
          integerNumber+=8;
        } else {
          integerNumber+=10;
        }
      }
    }
    return integerNumber;
  }
}
