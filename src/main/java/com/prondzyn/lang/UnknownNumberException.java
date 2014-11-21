package com.prondzyn.lang;

public class UnknownNumberException extends RuntimeException {

  public UnknownNumberException(Throwable cause) {
    super("It was probably a fucking weird number which I do not know. Sorry!", cause);
  }
}
