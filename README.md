About
=====

Numbers To Words Converter is a small library providing a functionality which converts numbers from numerical notation into English words spelling.

It uses [short scale for large numbers](https://en.wikipedia.org/wiki/Names_of_large_numbers#Standard_dictionary_numbers) which is primarily used by Americans, Canadians and modern British.

The largest recognized number equals 999 * 10^123.

Usage
=====

```java
System.out.println(NumbersToWordsConverter.convert(1)); // == "one"
System.out.println(NumbersToWordsConverter.convert(14)); // == "fourteen"
System.out.println(NumbersToWordsConverter.convert(67)); // == "sixty-seven"
System.out.println(NumbersToWordsConverter.convert(146)); // == "one hundred and forty-six"
System.out.println(NumbersToWordsConverter.convert(2222)); // == "two thousand two hundred and twenty-two"
```

License
=======

Numbers To Words Converter is available under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).
