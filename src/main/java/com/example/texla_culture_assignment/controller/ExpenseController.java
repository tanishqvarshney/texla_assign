package com.example.texla_culture_assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.texla_culture_assignment.models.Expense;
import com.example.texla_culture_assignment.services.ExpensePdfService;
import com.example.texla_culture_assignment.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

  @Autowired
  private ExpenseService expenseService;

  @Autowired
  private ExpensePdfService expensePdfService;

  @GetMapping
  public ResponseEntity<List<Expense>> getAllExpense() {
    List<Expense> allExpenses = expenseService.getAllExpenses();
    return new ResponseEntity<List<Expense>>(allExpenses, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Expense> createExpense(
      @Valid @RequestBody Expense expense) {
    Expense createdExpense = expenseService.createExpense(expense);
    return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
  }

  @PostMapping("/upload/{expenseId}")
  public ResponseEntity<Expense> uploadExpensePdf(
      @RequestParam("pdf") MultipartFile pdf,
      @PathVariable("expenseId") String expenseId) {
    Expense uploadedExpensePdf = expensePdfService.getExpensePdf(expenseId, pdf);
    return new ResponseEntity<>(uploadedExpensePdf, HttpStatus.OK);
  }

  @PostMapping("/claim/{expenseId}")
  public ResponseEntity<Expense> claimExpense(@PathVariable("expenseId") String expenseId) {
    Expense claimedExpense = expenseService.claimExpense(expenseId);
    return new ResponseEntity<Expense>(claimedExpense, HttpStatus.OK);
  }
}
