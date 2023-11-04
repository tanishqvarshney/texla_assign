package com.example.texla_culture_assignment.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
  private String messsage;
  private boolean isSuccess;
}
