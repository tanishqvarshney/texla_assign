package com.example.texla_culture_assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.texla_culture_assignment.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, String> {

}
