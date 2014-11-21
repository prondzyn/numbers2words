package com.prondzyn.numbers.converter

import com.prondzyn.lang.UnknownNumberException
import spock.lang.Specification

class NumbersToWordsConverterSpec extends Specification {

  def "say all digits"() {

    expect:
    NumbersToWordsConverter.convert(digit) == word

    where:
    digit | word
    0     | "zero"
    1     | "one"
    2     | "two"
    3     | "three"
    4     | "four"
    5     | "five"
    6     | "six"
    7     | "seven"
    8     | "eight"
    9     | "nine"
  }


  def "say numbers from 10 to 19"() {

    expect:
    NumbersToWordsConverter.convert(number) == word

    where:
    number | word
    10     | "ten"
    11     | "eleven"
    12     | "twelve"
    13     | "thirteen"
    14     | "fourteen"
    15     | "fifteen"
    16     | "sixteen"
    17     | "seventeen"
    18     | "eighteen"
    19     | "nineteen"
  }

  def "say tens"() {

    expect:
    NumbersToWordsConverter.convert(number) == word

    where:
    number | word
    10     | "ten"
    20     | "twenty"
    30     | "thirty"
    40     | "forty"
    50     | "fifty"
    60     | "sixty"
    70     | "seventy"
    80     | "eighty"
    90     | "ninety"
  }

  def "say -1"() {
    expect:
    NumbersToWordsConverter.convert(-1) == "minus one"
  }

  def "say few numbers from 20 to 99"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number | phrase
    21     | "twenty-one"
    34     | "thirty-four"
    45     | "forty-five"
    57     | "fifty-seven"
    63     | "sixty-three"
    78     | "seventy-eight"
    82     | "eighty-two"
    96     | "ninety-six"
  }

  def "say hundreds"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number  | phrase
    100     | "one hundred"
    200     | "two hundred"
    300     | "three hundred"
    400     | "four hundred"
    500     | "five hundred"
    600     | "six hundred"
    700     | "seven hundred"
    800     | "eight hundred"
    900     | "nine hundred"
  }

  def "say few numbers from 100 to 999"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number | phrase
    194    | "one hundred and ninety-four"
    213    | "two hundred and thirteen"
    342    | "three hundred and forty-two"
    451    | "four hundred and fifty-one"
    579    | "five hundred and seventy-nine"
    638    | "six hundred and thirty-eight"
    786    | "seven hundred and eighty-six"
    827    | "eight hundred and twenty-seven"
    965    | "nine hundred and sixty-five"
  }

  def "say thousands"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number | phrase
    1000   | "one thousand"
    2000   | "two thousand"
    3000   | "three thousand"
    4000   | "four thousand"
    5000   | "five thousand"
    6000   | "six thousand"
    7000   | "seven thousand"
    8000   | "eight thousand"
    9000   | "nine thousand"
  }

  def "Group 1 (with 'and') from http://www.eslcafe.com/grammar/saying_large_numbers01.html"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number  | phrase
    1_011   | "one thousand and eleven"
    21_011  | "twenty-one thousand and eleven"
    721_011 | "seven hundred twenty-one thousand and eleven"
  }

  def "Group 2 (with 'and') from http://www.eslcafe.com/grammar/saying_large_numbers01.html"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number      | phrase
    1_256_721   | "one million two hundred fifty-six thousand seven hundred and twenty-one"
    31_256_721  | "thirty-one million two hundred fifty-six thousand seven hundred and twenty-one"
    631_256_721 | "six hundred thirty-one million two hundred fifty-six thousand seven hundred and twenty-one"
  }

  def "Group 3 (with 'and') from http://www.eslcafe.com/grammar/saying_large_numbers01.html"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number          | phrase
    1_492_638_526   | "one billion four hundred ninety-two million six hundred thirty-eight thousand five hundred and twenty-six"
    41_492_638_526  | "forty-one billion four hundred ninety-two million six hundred thirty-eight thousand five hundred and twenty-six"
    941_492_638_526 | "nine hundred forty-one billion four hundred ninety-two million six hundred thirty-eight thousand five hundred and twenty-six"
  }

  def "say Integer.MIN_VALUE (-2,147,483,648)"() {
    expect:
    NumbersToWordsConverter.convert(Integer.MIN_VALUE) == "minus two billion one hundred forty-seven million four hundred eighty-three thousand six hundred and forty-eight"
  }

  def "say Integer.MAX_VALUE (2,147,483,647)"() {
    expect:
    NumbersToWordsConverter.convert(Integer.MAX_VALUE) == "two billion one hundred forty-seven million four hundred eighty-three thousand six hundred and forty-seven"
  }

  def "say a fucking large numbers"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number                     | phrase
           230_941_492_638_526 | "two hundred thirty trillion nine hundred forty-one billion four hundred ninety-two million six hundred thirty-eight thousand five hundred and twenty-six"
        45_230_941_492_638_526 | "forty-five quadrillion two hundred thirty trillion nine hundred forty-one billion four hundred ninety-two million six hundred thirty-eight thousand five hundred and twenty-six"
    78_045_230_941_492_638_526 | "seventy-eight quintillion forty-five quadrillion two hundred thirty trillion nine hundred forty-one billion four hundred ninety-two million six hundred thirty-eight thousand five hundred and twenty-six"
  }

  def "say numbers consist of one and zeros"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
                   number | phrase
                        0 | "zero"
                        1 | "one"
                       10 | "ten"
                      100 | "one hundred"
                    1_000 | "one thousand"
                   10_000 | "ten thousand"
                  100_000 | "one hundred thousand"
                1_000_000 | "one million"
               10_000_000 | "ten million"
              100_000_000 | "one hundred million"
            1_000_000_000 | "one billion"
           10_000_000_000 | "ten billion"
          100_000_000_000 | "one hundred billion"
        1_000_000_000_000 | "one trillion"
       10_000_000_000_000 | "ten trillion"
      100_000_000_000_000 | "one hundred trillion"
    1_000_000_000_000_000 | "one quadrillion"
  }

  def "say numbers consist of ones"() {

    expect:
    NumbersToWordsConverter.convert(number) == phrase

    where:
    number | phrase
         1 | "one"
        11 | "eleven"
       111 | "one hundred and eleven"
     1_111 | "one thousand one hundred and eleven"
    11_111 | "eleven thousand one hundred and eleven"
  }

  def THE_LARGEST = 999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999_999

  def "say the largest number you can"() {

    expect:
    NumbersToWordsConverter.convert(THE_LARGEST) ==
        "nine hundred ninety-nine quadragintillion " +
        "nine hundred ninety-nine noventrigintillion " +
        "nine hundred ninety-nine octotrigintillion " +
        "nine hundred ninety-nine septentrigintillion " +
        "nine hundred ninety-nine sestrigintillion " +
        "nine hundred ninety-nine quinquatrigintillion " +
        "nine hundred ninety-nine quattuortrigintillion " +
        "nine hundred ninety-nine trestrigintillion " +
        "nine hundred ninety-nine duotrigintillion " +
        "nine hundred ninety-nine untrigintillion " +
        "nine hundred ninety-nine trigintillion " +
        "nine hundred ninety-nine novemvigintillion " +
        "nine hundred ninety-nine octovigintillion " +
        "nine hundred ninety-nine septemvigintillion " +
        "nine hundred ninety-nine sesvigintillion " +
        "nine hundred ninety-nine quinquavigintillion " +
        "nine hundred ninety-nine quattuorvigintillion " +
        "nine hundred ninety-nine tresvigintillion " +
        "nine hundred ninety-nine duovigintillion " +
        "nine hundred ninety-nine unvigintillion " +
        "nine hundred ninety-nine vigintillion " +
        "nine hundred ninety-nine novendecillion " +
        "nine hundred ninety-nine octodecillion " +
        "nine hundred ninety-nine septendecillion " +
        "nine hundred ninety-nine sedecillion " +
        "nine hundred ninety-nine quinquadecillion " +
        "nine hundred ninety-nine quattuordecillion " +
        "nine hundred ninety-nine tredecillion " +
        "nine hundred ninety-nine duodecillion " +
        "nine hundred ninety-nine undecillion " +
        "nine hundred ninety-nine decillion " +
        "nine hundred ninety-nine nonillion " +
        "nine hundred ninety-nine octillion " +
        "nine hundred ninety-nine septillion " +
        "nine hundred ninety-nine sextillion " +
        "nine hundred ninety-nine quintillion " +
        "nine hundred ninety-nine quadrillion " +
        "nine hundred ninety-nine trillion " +
        "nine hundred ninety-nine billion " +
        "nine hundred ninety-nine million " +
        "nine hundred ninety-nine thousand " +
        "nine hundred and ninety-nine"
  }

  def "you cannot say the largest number increased by one"() {

    when:
    NumbersToWordsConverter.convert(THE_LARGEST + 1)

    then:
    def ex = thrown(UnknownNumberException)
    ex.message == "It was probably a fucking weird number which I do not know. Sorry!"
  }

  def FUNNY_NUMBER = 111_222_333_444_555_666_777_888_999_012_345_678_901_234_567_890_123_456_789_345_678_956_789_321_432_543_654_765_876_987_098_109_210_321_432_543_654_765_876_987_098_435

  def "say the funny number"() {

    expect:
    NumbersToWordsConverter.convert(FUNNY_NUMBER) ==
        "one hundred eleven quadragintillion " +
        "two hundred twenty-two noventrigintillion " +
        "three hundred thirty-three octotrigintillion " +
        "four hundred forty-four septentrigintillion " +
        "five hundred fifty-five sestrigintillion " +
        "six hundred sixty-six quinquatrigintillion " +
        "seven hundred seventy-seven quattuortrigintillion " +
        "eight hundred eighty-eight trestrigintillion " +
        "nine hundred ninety-nine duotrigintillion " +
        "twelve untrigintillion " +
        "three hundred forty-five trigintillion " +
        "six hundred seventy-eight novemvigintillion " +
        "nine hundred one octovigintillion " +
        "two hundred thirty-four septemvigintillion " +
        "five hundred sixty-seven sesvigintillion " +
        "eight hundred ninety quinquavigintillion " +
        "one hundred twenty-three quattuorvigintillion " +
        "four hundred fifty-six tresvigintillion " +
        "seven hundred eighty-nine duovigintillion " +
        "three hundred forty-five unvigintillion " +
        "six hundred seventy-eight vigintillion " +
        "nine hundred fifty-six novendecillion " +
        "seven hundred eighty-nine octodecillion " +
        "three hundred twenty-one septendecillion " +
        "four hundred thirty-two sedecillion " +
        "five hundred forty-three quinquadecillion " +
        "six hundred fifty-four quattuordecillion " +
        "seven hundred sixty-five tredecillion " +
        "eight hundred seventy-six duodecillion " +
        "nine hundred eighty-seven undecillion " +
        "ninety-eight decillion " +
        "one hundred nine nonillion " +
        "two hundred ten octillion " +
        "three hundred twenty-one septillion " +
        "four hundred thirty-two sextillion " +
        "five hundred forty-three quintillion " +
        "six hundred fifty-four quadrillion " +
        "seven hundred sixty-five trillion " +
        "eight hundred seventy-six billion " +
        "nine hundred eighty-seven million " +
        "ninety-eight thousand " +
        "four hundred and thirty-five"
  }
}