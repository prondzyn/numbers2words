package com.prondzyn.numbers.writer;

import com.prondzyn.lang.UnknownNumberException;

import java.math.BigInteger;

import static com.prondzyn.numbers.writer.BigIntegerUtils.*;
import static com.prondzyn.numbers.writer.EnglishNumbers.*;
import static com.prondzyn.numbers.writer.StringUtils.*;

public abstract class NumbersToWordsWriter {

  /**
   * Writes given number from numerical notation into English words.<br/>
   * <br/>
   * For more details see {@link NumbersToWordsWriter#writeUsingWords(int)} method.
   *
   * @param number the number to write
   * @return given number written into English words
   */
  public static String writeUsingWords(BigInteger number) {
    return writeUsingWords(number, true);
  }

  /**
   * Writes given number from numerical notation into English words.<br/>
   * <br/>
   * Examples:<br/>
   * <code>NumbersToWordsWriter.writeUsingWords(1); => "one"</code><br/>
   * <code>NumbersToWordsWriter.writeUsingWords(14); => "fourteen"</code><br/>
   * <code>NumbersToWordsWriter.writeUsingWords(67); => "sixty-seven"</code><br/>
   * <code>NumbersToWordsWriter.writeUsingWords(146); => "one hundred and forty-six"</code><br/>
   * <code>NumbersToWordsWriter.writeUsingWords(2222); => "two thousand two hundred and twenty-two"</code><br/>
   * <br/>
   * Method uses short scale for large numbers[1] which is primarily used by Americans, Canadians and modern British.<br/>
   * <br/>
   * [1] <a href="https://en.wikipedia.org/wiki/Names_of_large_numbers#Standard_dictionary_numbers">Wikipedia: Names of large numbers</a>
   *
   * @param number the number to write
   * @return given number written into English words
   */
  public static String writeUsingWords(int number) {
    return writeUsingWords(parse(number));
  }

  /**
   * Writes given number from numerical notation into English words.<br/>
   * <br/>
   * For more details see {@link NumbersToWordsWriter#writeUsingWords(int)} method.
   *
   * @param number the number to write
   * @return given number written into English words
   */
  public static String writeUsingWords(long number) {
    return writeUsingWords(parse(number));
  }

  /**
   * Writes given number from numerical notation into English words.<br/>
   * <br/>
   * For more details see {@link NumbersToWordsWriter#writeUsingWords(int)} method.
   *
   * @param number the number to write
   * @return given number written into English words
   */
  public static String writeUsingWords(String number) {
    try {
      return writeUsingWords(new BigInteger(number));
    } catch (NumberFormatException ex) {
      throw new UnknownNumberException(ex);
    }
  }

  private static String writeUsingWords(BigInteger number, boolean andRequired) {
    if (lt.zero(number)) {
      return minus(writeUsingWords(number.negate()));
    } else if (lt.twenty(number)) {
      return writeNumberBetween0and19(number);
    } else if (lt.hundred(number)) {
      return writeNumberBetween20and99(number);
    } else if (lt.thousand(number)) {
      return writeNumberBetween100and999(number, andRequired);
    } else if (lt.million(number)) {
      return writeNumberBetween1000and999999(number, andRequired);
    } else {
      return writeNumberGreaterThan999999(number);
    }
  }

  private static String writeNumberBetween0and19(BigInteger number) {
    return NUMBERS_FROM_0_TO_19(number);
  }

  private static String writeNumberBetween20and99(BigInteger number) {
    BigInteger d = div.ten(number);
    BigInteger m = mod.ten(number);
    return formatNumberGreaterThanNineteenAndLessThanHundred(m, TENS(d), NUMBERS_FROM_0_TO_19(m));
  }

  private static String writeNumberBetween100and999(BigInteger number, boolean andRequired) {
    BigInteger d = div.hundred(number);
    BigInteger m = mod.hundred(number);
    return format(m, NUMBERS_FROM_0_TO_19(d), BIG_NUMBERS(0), concat(and(andRequired), writeUsingWords(m)));
  }

  private static String writeNumberBetween1000and999999(BigInteger number, boolean andRequired) {
    BigInteger d = div.thousand(number);
    BigInteger m = mod.thousand(number);
    return format(m, writeUsingWords(d, false), BIG_NUMBERS(1), concat(and(andRequired && lt.twenty(m)), writeUsingWords(m)));
  }

  private static String writeNumberGreaterThan999999(BigInteger number) {
    int idx = index(number);
    int exponent = idx * 3;
    BigInteger pow = powTenTo(exponent);
    BigInteger div = div(number, pow);
    BigInteger mod = mod(number, pow);
    return format(mod, writeUsingWords(div, false), BIG_NUMBERS(idx), writeUsingWords(mod, false));
  }
}
