package com.prondzyn.numbers.converter;

import com.prondzyn.lang.UnknownNumberException;

import java.math.BigInteger;

import static com.prondzyn.numbers.converter.BigIntegerUtils.*;
import static com.prondzyn.numbers.converter.EnglishNumbers.*;
import static com.prondzyn.numbers.converter.StringUtils.*;

public abstract class NumbersToWordsConverter {

  /**
   * Converts given number from numerical notation into English words spelling.<br/>
   * <br/>
   * For more details see {@link com.prondzyn.numbers.converter.NumbersToWordsConverter#convert(int)} method.
   *
   * @param number the number to convert
   * @return given number converted into English words spelling
   */
  public static String convert(BigInteger number) {
    return convert(number, true);
  }

  /**
   * Converts given number from numerical notation into English words spelling.<br/>
   * <br/>
   * Examples:<br/>
   * <code>NumbersToWordsConverter.convert(1); => "one"</code><br/>
   * <code>NumbersToWordsConverter.convert(14); => "fourteen"</code><br/>
   * <code>NumbersToWordsConverter.convert(67); => "sixty-seven"</code><br/>
   * <code>NumbersToWordsConverter.convert(146); => "one hundred and forty-six"</code><br/>
   * <code>NumbersToWordsConverter.convert(2222); => "two thousand two hundred and twenty-two"</code><br/>
   * <br/>
   * Method uses short scale for large numbers[1] which is primarily used by Americans, Canadians and modern British.<br/>
   * <br/>
   * [1] <a href="https://en.wikipedia.org/wiki/Names_of_large_numbers#Standard_dictionary_numbers">Wikipedia: Names of large numbers</a>
   *
   * @param number the number to convert
   * @return given number converted into English words spelling
   */
  public static String convert(int number) {
    return convert(parse(number));
  }

  /**
   * Converts given number from numerical notation into English words spelling.<br/>
   * <br/>
   * For more details see {@link com.prondzyn.numbers.converter.NumbersToWordsConverter#convert(int)} method.
   *
   * @param number the number to convert
   * @return given number converted into English words spelling
   */
  public static String convert(long number) {
    return convert(parse(number));
  }

  /**
   * Converts given number from numerical notation into English words spelling.<br/>
   * <br/>
   * For more details see {@link com.prondzyn.numbers.converter.NumbersToWordsConverter#convert(int)} method.
   *
   * @param number the number to convert
   * @return given number converted into English words spelling
   */
  public static String convert(String number) {
    try {
      return convert(new BigInteger(number));
    } catch (NumberFormatException ex) {
      throw new UnknownNumberException(ex);
    }
  }

  private static String convert(BigInteger number, boolean andRequired) {
    if (lt.zero(number)) {
      return minus(convert(number.negate()));
    } else if (lt.twenty(number)) {
      return convertNumberBetween0and19(number);
    } else if (lt.hundred(number)) {
      return convertNumberBetween20and99(number);
    } else if (lt.thousand(number)) {
      return convertNumberBetween100and999(number, andRequired);
    } else if (lt.million(number)) {
      return convertNumberBetween1000and999999(number, andRequired);
    } else {
      return convertNumberGreaterThan999999(number);
    }
  }

  private static String convertNumberBetween0and19(BigInteger number) {
    return NUMBERS_FROM_0_TO_19(number);
  }

  private static String convertNumberBetween20and99(BigInteger number) {
    BigInteger d = div.ten(number);
    BigInteger m = mod.ten(number);
    return formatNumberGreaterThanNineteenAndLessThanHundred(m, TENS(d), NUMBERS_FROM_0_TO_19(m));
  }

  private static String convertNumberBetween100and999(BigInteger number, boolean andRequired) {
    BigInteger d = div.hundred(number);
    BigInteger m = mod.hundred(number);
    return format(m, NUMBERS_FROM_0_TO_19(d), BIG_NUMBERS(0), concat(and(andRequired), convert(m)));
  }

  private static String convertNumberBetween1000and999999(BigInteger number, boolean andRequired) {
    BigInteger d = div.thousand(number);
    BigInteger m = mod.thousand(number);
    return format(m, convert(d, false), BIG_NUMBERS(1), concat(and(andRequired && lt.twenty(m)), convert(m)));
  }

  private static String convertNumberGreaterThan999999(BigInteger number) {
    int idx = index(number);
    int exponent = idx * 3;
    BigInteger pow = powTenTo(exponent);
    BigInteger div = div(number, pow);
    BigInteger mod = mod(number, pow);
    return format(mod, convert(div, false), BIG_NUMBERS(idx), convert(mod, false));
  }
}
