package com.example.texla_culture_assignment.services;

import java.util.List;

import com.example.texla_culture_assignment.models.Expense;

public interface ExpenseService {
  // CREATE EXPENSE
  Expense createExpense(Expense expense);

  // CLAIM EXPENSE
  Expense claimExpense(String expenseId);

  // GET ALL EXPENSES
  List<Expense> getAllExpenses();
}
