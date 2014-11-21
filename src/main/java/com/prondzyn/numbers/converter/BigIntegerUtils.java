package com.prondzyn.numbers.converter;

import java.math.BigInteger;

import static java.math.BigInteger.*;

class BigIntegerUtils {

  private static final BigInteger TWENTY = new BigInteger("20");
  private static final BigInteger HUNDRED = powTenTo(2);
  private static final BigInteger THOUSAND = powTenTo(3);
  private static final BigInteger MILLION = powTenTo(6);

  static int index(BigInteger number) {
    int length = number.toString().length();
    int lDiv3 = length / 3;
    int lMod3 = length % 3;
    return (lMod3 > 0) ? lDiv3 : (lDiv3 - 1);
  }

  static BigInteger powTenTo(int exponent) {
    StringBuilder builder = new StringBuilder("1");
    for (int i = 0; i < exponent; i++) builder.append("0");
    return new BigInteger(builder.toString());
  }

  static class gt {
    static boolean zero(BigInteger number) {
      return firstLtSecond(ZERO, number);
    }
  }

  static class lt {

    static boolean zero(BigInteger number) {
      return firstLtSecond(number, ZERO);
    }

    static boolean twenty(BigInteger number) {
      return firstLtSecond(number, TWENTY);
    }

    static boolean hundred(BigInteger number) {
      return firstLtSecond(number, HUNDRED);
    }

    static boolean thousand(BigInteger number) {
      return firstLtSecond(number, THOUSAND);
    }

    static boolean million(BigInteger number) {
      return firstLtSecond(number, MILLION);
    }
  }

  private static boolean firstLtSecond(BigInteger first, BigInteger second) {
    return first.compareTo(second) == -1;
  }

  static class div {

    static BigInteger ten(BigInteger dividend) {
      return div(dividend, TEN);
    }

    static BigInteger hundred(BigInteger dividend) {
      return div(dividend, HUNDRED);
    }

    static BigInteger thousand(BigInteger dividend) {
      return div(dividend, THOUSAND);
    }
  }

  static BigInteger div(BigInteger dividend, BigInteger divisor) {
    return dividend.divide(divisor);
  }

  static class mod {

    static BigInteger ten(BigInteger dividend) {
      return mod(dividend, TEN);
    }

    static BigInteger hundred(BigInteger dividend) {
      return mod(dividend, HUNDRED);
    }

    static BigInteger thousand(BigInteger dividend) {
      return mod(dividend, THOUSAND);
    }
  }

  static BigInteger mod(BigInteger dividend, BigInteger divisor) {
    return dividend.mod(divisor);
  }

  static int toInt(BigInteger number) {
    return number.intValue();
  }

  static BigInteger parse(int number) {
    return new BigInteger("" + number);
  }

  static BigInteger parse(long number) {
    return new BigInteger("" + number);
  }
}
