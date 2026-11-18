package com.expensetracker.expensetracker.DTOs;

import com.expensetracker.expensetracker.Entity.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseResponse(
        Long id,
        String itemName,
        BigDecimal amount,
        String currency,
        String storeLocation,
        String description,
        LocalDate expenseDate
) {
    public static ExpenseResponse fromEntity(Expense expense){
        return new ExpenseResponse(
                expense.getId(),
                expense.getItemName(),
                expense.getAmount(),
                expense.getCurrency(),
                expense.getStoreLocation(),
                expense.getDescription(),
                expense.getExpenseDate()
        );
    }
}
