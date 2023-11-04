package com.example.texla_culture_assignment.exceptions;

public class ApiException extends RuntimeException {

  public ApiException(String message) {
    super(message);
  }

  public ApiException() {
    super("");
  }
}
