package com.example.texla_culture_assignment.services.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.texla_culture_assignment.exceptions.ResourceNotFoundException;
import com.example.texla_culture_assignment.models.Expense;
import com.example.texla_culture_assignment.repositories.ExpenseRepository;
import com.example.texla_culture_assignment.services.ExpenseService;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

  @Autowired
  private ExpenseRepository expenseRepository;

  @Override
  public Expense createExpense(Expense expense) {
    expense.setExpenseId(UUID.randomUUID().toString());
    expense.setClaimed(false);
    expense.setDate(LocalDate.now());
    expense.setExpensePdfFilename("default.pdf");
    Expense savedExpense = expenseRepository.save(expense);
    return savedExpense;
  }

  @Override
  public Expense claimExpense(String expenseId) {
    Expense expense = expenseRepository.findById(expenseId)
        .orElseThrow(() -> new ResourceNotFoundException("Expense", "expenseId ", expenseId));
    expense.setClaimed(true);
    Expense claimedExpense = expenseRepository.save(expense);
    return claimedExpense;
  }

  @Override
  public List<Expense> getAllExpenses() {
    List<Expense> allExpenses = expenseRepository.findAll();
    return allExpenses;
  }

}
