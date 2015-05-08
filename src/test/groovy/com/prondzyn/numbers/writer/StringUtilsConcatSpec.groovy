package com.prondzyn.numbers.writer

import spock.lang.Specification

class StringUtilsConcatSpec extends Specification {

  def "'nine ' + 'teen' = 'nineteen'"() {

    expect:
    StringUtils.concat("nine", "teen") == "nineteen"
  }

  def "'foo' + 'bar' = 'foobar'"() {

    expect:
    StringUtils.concat("foo", "bar") == "foobar"
  }
}