package com.expensetracker.expensetracker.Repository;

import com.expensetracker.expensetracker.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
