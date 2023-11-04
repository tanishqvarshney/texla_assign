package com.example.texla_culture_assignment.services.implementation;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.texla_culture_assignment.exceptions.ResourceNotFoundException;
import com.example.texla_culture_assignment.models.Expense;
import com.example.texla_culture_assignment.repositories.ExpenseRepository;
import com.example.texla_culture_assignment.services.ExpensePdfService;

@Service
public class ExpensePdfServiceImpl implements ExpensePdfService {

  @Autowired
  private ExpenseRepository expenseRepository;

  @Override
  public Expense getExpensePdf(String expenseId, MultipartFile pdfFile) {
    Expense expense = expenseRepository.findById(expenseId)
        .orElseThrow(() -> new ResourceNotFoundException("Expense", "expenseId ", expenseId));
    expense.setExpensePdfFilename(pdfFile.getOriginalFilename());
    Expense savedExpense = expenseRepository.save(expense);
    return savedExpense;
  }

}
