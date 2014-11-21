package com.prondzyn.numbers.converter;

import com.prondzyn.lang.UnknownNumberException;

import java.math.BigInteger;

import static com.prondzyn.numbers.converter.BigIntegerUtils.*;
import static com.prondzyn.numbers.converter.StringUtils.*;

class EnglishNumbers {

  private static final String MINUS = "minus ";
  private static final String AND = "and ";

  private static final String[] NUMBERS_FROM_0_TO_19 = {
      "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
      "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
  };

  private static final String[] TENS = {
      "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
  };

  private static final String[] SCALE = {
      /* 10  ^2 */ "hundred",
      /* 10  ^3 */ "thousand",
      /* 10  ^6 */ "million",
      /* 10  ^9 */ "billion",
      /* 10 ^12 */ "trillion",
      /* 10 ^15 */ "quadrillion",
      /* 10 ^18 */ "quintillion",
      /* 10 ^21 */ "sextillion",
      /* 10 ^24 */ "septillion",
      /* 10 ^27 */ "octillion",
      /* 10 ^30 */ "nonillion",
      /* 10 ^33 */ "decillion",
      /* 10 ^36 */ "undecillion",
      /* 10 ^39 */ "duodecillion",
      /* 10 ^42 */ "tredecillion",
      /* 10 ^45 */ "quattuordecillion",
      /* 10 ^48 */ "quinquadecillion",
      /* 10 ^51 */ "sedecillion",
      /* 10 ^54 */ "septendecillion",
      /* 10 ^57 */ "octodecillion",
      /* 10 ^60 */ "novendecillion",
      /* 10 ^63 */ "vigintillion",
      /* 10 ^66 */ "unvigintillion",
      /* 10 ^69 */ "duovigintillion",
      /* 10 ^72 */ "tresvigintillion",
      /* 10 ^75 */ "quattuorvigintillion",
      /* 10 ^78 */ "quinquavigintillion",
      /* 10 ^81 */ "sesvigintillion",
      /* 10 ^84 */ "septemvigintillion",
      /* 10 ^87 */ "octovigintillion",
      /* 10 ^90 */ "novemvigintillion",
      /* 10 ^93 */ "trigintillion",
      /* 10 ^96 */ "untrigintillion",
      /* 10 ^99 */ "duotrigintillion",
      /* 10^102 */ "trestrigintillion",
      /* 10^105 */ "quattuortrigintillion",
      /* 10^108 */ "quinquatrigintillion",
      /* 10^111 */ "sestrigintillion",
      /* 10^114 */ "septentrigintillion",
      /* 10^117 */ "octotrigintillion",
      /* 10^120 */ "noventrigintillion",
      /* 10^123 */ "quadragintillion"
  };

  static String NUMBERS_FROM_0_TO_19(BigInteger number) {
    return numbersFromArray(toInt(number), NUMBERS_FROM_0_TO_19);
  }

  static String TENS(BigInteger index) {
    return numbersFromArray(toInt(index), TENS);
  }

  static String BIG_NUMBERS(int index) {
    return numbersFromArray(index, SCALE);
  }

  private static String numbersFromArray(int number, String[] array) {
    try {
      return array[number];
    } catch (ArrayIndexOutOfBoundsException ex) {
      throw new UnknownNumberException(ex);
    }
  }

  static String minus(String phrase) {
    return concat(MINUS, phrase);
  }

  static String and(boolean isRequired) {
    return (isRequired ? AND : "");
  }
}
