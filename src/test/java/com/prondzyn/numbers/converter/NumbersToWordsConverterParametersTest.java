package com.prondzyn.numbers.converter;

import com.prondzyn.lang.UnknownNumberException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class NumbersToWordsConverterParametersTest {

  @Test
  public void testIntParameter() {
    Assert.assertEquals("one thousand one hundred and eleven", NumbersToWordsConverter.convert(1111));
  }

  @Test
  public void testLongParameter() {
    Assert.assertEquals(
        "thirty-three billion three hundred thirty-three million three hundred thirty-three thousand three hundred and thirty-three",
        NumbersToWordsConverter.convert(33_333_333_333L)
    );
  }

  @Test
  public void testBigIntegerParameter() {
    Assert.assertEquals(
        "one hundred twenty-three million four hundred fifty-six thousand seven hundred and eighty-nine",
        NumbersToWordsConverter.convert(new BigInteger("123456789"))
    );
  }

  @Test
  public void testStringParameter() {
    Assert.assertEquals(
        "one hundred twenty-three million four hundred fifty-six thousand seven hundred and eighty-nine",
        NumbersToWordsConverter.convert("123456789")
    );
  }

  @Test(expected = UnknownNumberException.class)
  public void testInvalidStringParameter() {
    NumbersToWordsConverter.convert("This is not a number. THIS IS SPARTA!!!");
  }
}
