package com.prondzyn.numbers.converter

import spock.lang.Specification

class StringUtilsFormatNumberGreaterThanNineteenAndLessThanHundredSpec extends Specification {

  def "At least three arguments are required for the 'formatNumberGreaterThanTwentyAndLessThanHundred' function."() {

    when:
    StringUtils.formatNumberGreaterThanNineteenAndLessThanHundred(0);

    then:
    def ex = thrown(IllegalArgumentException)
    ex.message == "Too few arguments passed to the function. Two or three are required depending of value of the 'value' argument."
  }

  def "If value less than or equals zero then three arguments are required in the 'formatNumberGreaterThanTwentyAndLessThanHundred' function."() {

    expect:
    StringUtils.formatNumberGreaterThanNineteenAndLessThanHundred(0, "nineteen") == "nineteen";
  }

  def "If value greater than zero then four arguments are required in the 'formatNumberGreaterThanTwentyAndLessThanHundred' function."() {

    expect:
    StringUtils.formatNumberGreaterThanNineteenAndLessThanHundred(1, "forty", "five") == "forty-five";
  }

  def "Fifth and next arguments are ignored in the 'formatNumberGreaterThanTwentyAndLessThanHundred' function."() {

    expect:
    StringUtils.formatNumberGreaterThanNineteenAndLessThanHundred(
        1, "forty", "five", "this will be ignored", "and this will be ignored too"
    ) == "forty-five";
  }
}