package com.example.texla_culture_assignment.services;

import org.springframework.web.multipart.MultipartFile;

import com.example.texla_culture_assignment.models.Expense;

public interface ExpensePdfService {

  Expense getExpensePdf(String expenseId, MultipartFile pdfFile);
}
