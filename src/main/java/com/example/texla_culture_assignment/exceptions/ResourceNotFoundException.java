package com.example.texla_culture_assignment.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
  String resourceName;
  String fieldName;
  String fieldValue;
  String fieldValueString;

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueString) {
    super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValueString));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValueString = fieldValueString;
  }
}
