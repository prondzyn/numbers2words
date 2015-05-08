package com.prondzyn.numbers.writer;

import com.prondzyn.lang.UnknownNumberException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class NumbersToWordsWriterParametersTest {

  @Test
  public void testIntParameter() {
    Assert.assertEquals("one thousand one hundred and eleven", NumbersToWordsWriter.writeUsingWords(1111));
  }

  @Test
  public void testLongParameter() {
    Assert.assertEquals(
        "thirty-three billion three hundred thirty-three million three hundred thirty-three thousand three hundred and thirty-three",
        NumbersToWordsWriter.writeUsingWords(33_333_333_333L)
    );
  }

  @Test
  public void testBigIntegerParameter() {
    Assert.assertEquals(
        "one hundred twenty-three million four hundred fifty-six thousand seven hundred and eighty-nine",
        NumbersToWordsWriter.writeUsingWords(new BigInteger("123456789"))
    );
  }

  @Test
  public void testStringParameter() {
    Assert.assertEquals(
        "one hundred twenty-three million four hundred fifty-six thousand seven hundred and eighty-nine",
        NumbersToWordsWriter.writeUsingWords("123456789")
    );
  }

  @Test(expected = UnknownNumberException.class)
  public void testInvalidStringParameter() {
    NumbersToWordsWriter.writeUsingWords("This is not a number. THIS IS SPARTA!!!");
  }
}
