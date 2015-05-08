package com.prondzyn.numbers.writer

import spock.lang.Specification

class StringUtilsFormatSpec extends Specification {

  def "At least three arguments are required for the 'format' function."() {

    when:
    StringUtils.format(0);

    then:
    def ex = thrown(IllegalArgumentException)
    ex.message == "Too few arguments passed to the function. Three or four are required depending of value of the 'value' argument."
  }

  def "If value less than or equals zero then three arguments are required in the 'format' function."() {

    expect:
    StringUtils.format(0, "forty-five", "hundred") == "forty-five hundred";
  }

  def "If value greater than zero then four arguments are required in the 'format' function."() {

    expect:
    StringUtils.format(1, "forty-five", "hundred", "and one") == "forty-five hundred and one";
  }

  def "Fifth and next arguments are ignored in the 'format' function."() {

    expect:
    StringUtils.format(
        1, "forty-five", "hundred", "and one", "this will be ignored", "and this will be ignored too"
    ) == "forty-five hundred and one";
  }
}