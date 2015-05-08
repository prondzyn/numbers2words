package com.prondzyn.numbers.writer

import spock.lang.Specification

class BigIntegerUtilsSpec extends Specification {

  def "The 'index' function returns the number which helps me but I have no idea how to say about it in English."() {

    expect:
    BigIntegerUtils.index(value) == idx;

    where:
    value      | idx
             0 | 0
             9 | 0
            10 | 0
            99 | 0
           100 | 0
           999 | 0
         1_000 | 1
         9_999 | 1
        10_000 | 1
        99_999 | 1
       100_000 | 1
       999_999 | 1
     1_000_000 | 2
     9_999_999 | 2
    10_000_000 | 2
    99_999_999 | 2
  }

  def "power 10 to few exponents"() {

    expect:
    BigIntegerUtils.powTenTo(exponent) == power;

    where:
    exponent | power
    1        | 10
    2        | 100
    3        | 1000
    4        | 10_000
    5        | 100_000
    10       | 10_000_000_000
    15       | 1_000_000_000_000_000
    25       | 10_000_000_000_000_000_000_000_000
  }

  def "test greater than 0 (gt.zero)"() {

    expect:
    BigIntegerUtils.gt.zero(value) == result;

    where:
    value | result
    -99   | false
    -1    | false
    0     | false
    1     | true
    99    | true
  }

  def "test less than 0 (lt.zero)"() {

    expect:
    BigIntegerUtils.lt.zero(value) == result;

    where:
    value | result
    -99   | true
    -1    | true
    0     | false
    1     | false
    99    | false
  }

  def "test less than 20 (lt.twenty)"() {

    expect:
    BigIntegerUtils.lt.twenty(value) == result;

    where:
    value | result
    -99   | true
    -1    | true
    0     | true
    1     | true
    19    | true
    20    | false
    99    | false
  }

  def "test less than 100 (lt.hundred)"() {

    expect:
    BigIntegerUtils.lt.hundred(value) == result;

    where:
    value | result
    -99   | true
    -1    | true
    0     | true
    1     | true
    19    | true
    20    | true
    99    | true
    100   | false
    999   | false
  }

  def "test less than 1000 (lt.thousand)"() {

    expect:
    BigIntegerUtils.lt.thousand(value) == result;

    where:
    value | result
    -99   | true
    -1    | true
    0     | true
    1     | true
    19    | true
    20    | true
    99    | true
    100   | true
    999   | true
    1000  | false
    9999  | false
  }

  def "test less than one million (lt.million)"() {

    expect:
    BigIntegerUtils.lt.million(value) == result;

    where:
    value   | result
    -99     | true
    -1      | true
    0       | true
    1       | true
    19      | true
    20      | true
    99      | true
    100     | true
    999     | true
    1000    | true
    999999  | true
    1000000 | false
    9999999 | false
  }

  def "test division by various numbers"() {

    expect:
    BigIntegerUtils.div(a, b) == c;

    where:
    a  | b | c
    10 | 3 | 3
    15 | 2 | 7
    14 | 4 | 3
    45 | 9 | 5
    67 | 5 | 13
  }

  def "test division by 10"() {

    expect:
    BigIntegerUtils.div.ten(value) == result;

    where:
    value | result
    -999  | -99
    -99   | -9
    -9    | 0
    0     | 0
    3     | 0
    7     | 0
    11    | 1
    23    | 2
  }

  def "test division by 100"() {

    expect:
    BigIntegerUtils.div.hundred(value) == result;

    where:
    value | result
    -999  | -9
    -99   | 0
    -9    | 0
    0     | 0
    11    | 0
    23    | 0
    100   | 1
    200   | 2
    201   | 2
    299   | 2
  }

  def "test division by 1000"() {

    expect:
    BigIntegerUtils.div.thousand(value) == result;

    where:
    value   | result
    -10_000 | -10
    -1_000  | -1
    -999    | 0
    -1      | 0
    0       | 0
    1       | 0
    999     | 0
    1000    | 1
    1001    | 1
    2000    | 2
    3001    | 3
  }

  def "test modulo various numbers"() {

    expect:
    BigIntegerUtils.mod(a, b) == c;

    where:
    a  | b | c
    10 | 3 | 1
    15 | 2 | 1
    14 | 4 | 2
    45 | 9 | 0
    67 | 5 | 2
  }

  def "test modulo 10"() {

    expect:
    BigIntegerUtils.mod.ten(value) == result;

    where:
    value | result
    -999  | 1
    -99   | 1
    -9    | 1
    0     | 0
    3     | 3
    7     | 7
    11    | 1
    23    | 3
  }

  def "test modulo 100"() {

    expect:
    BigIntegerUtils.mod.hundred(value) == result;

    where:
    value | result
    -999  | 1
    -99   | 1
    -9    | 91
    0     | 0
    11    | 11
    23    | 23
    100   | 0
    200   | 0
    201   | 1
    299   | 99
  }

  def "test modulo 1000"() {

    expect:
    BigIntegerUtils.mod.thousand(value) == result;

    where:
    value   | result
    -10_000 | 0
    -1_000  | 0
    -999    | 1
    -1      | 999
    0       | 0
    1       | 1
    999     | 999
    1000    | 0
    1001    | 1
    2000    | 0
    3001    | 1
  }
}