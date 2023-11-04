package com.example.texla_culture_assignment.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Expense {

  @Id
  private String expenseId;

  @Size(min = 3, message = "Description must be of atleast 3 charaters")
  @Column(nullable = false)
  @NotBlank(message = "Description cannot be empty")
  private String description;

  @Column(nullable = false)
  private double amount;
  private boolean isClaimed;
  private LocalDate date;
  private String expensePdfFilename;
}
