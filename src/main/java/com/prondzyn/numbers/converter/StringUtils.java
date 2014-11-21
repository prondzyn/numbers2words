package com.prondzyn.numbers.converter;

import java.math.BigInteger;
import java.util.MissingFormatArgumentException;

import static com.prondzyn.numbers.converter.BigIntegerUtils.gt;

class StringUtils {

  static String concat(String string1, String string2) {
    return String.format("%s%s", string1, string2);
  }

  static String format(BigInteger value, Object... args) {
    String msg = "Too few arguments passed to the function. Three or four are required depending of value of the 'value' argument.";
    return formatWithSpecifiedFormats(value, msg, "%s %s %s", "%s %s", args);
  }

  static String formatNumberGreaterThanNineteenAndLessThanHundred(BigInteger value, Object... args) {
    String msg = "Too few arguments passed to the function. Two or three are required depending of value of the 'value' argument.";
    return formatWithSpecifiedFormats(value, msg, "%s-%s", "%s", args);
  }

  private static String formatWithSpecifiedFormats(BigInteger value, String errorMessage, String formatWhenGreaterThanZero, String formatWhenZero, Object... args) {
    try {
      return String.format(prepareFormat(value, formatWhenGreaterThanZero, formatWhenZero), args);
    } catch (MissingFormatArgumentException ex) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private static String prepareFormat(BigInteger value, String formatWhenGreaterThanZero, String formatWhenZero) {
    return gt.zero(value) ? formatWhenGreaterThanZero : formatWhenZero;
  }
}
