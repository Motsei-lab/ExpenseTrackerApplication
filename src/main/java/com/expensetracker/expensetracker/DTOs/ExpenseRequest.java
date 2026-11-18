package com.expensetracker.expensetracker.DTOs;

import com.expensetracker.expensetracker.Entity.Expense;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseRequest(
        @NotBlank(message = "Item name is required")
        @Size(max = 100, message = "Item name must not exceed 100 characters")
        String itemName,
        @NotNull(message = "Amount is required")
        BigDecimal amount,
        @NotBlank(message = "Currency is required")
        @Size(max = 3, message = "Currency must be a 3-letter code (e.g. USD, EUR, ZAR)")
        String currency,
        String storeLocation,
        String description,
        @NotNull(message = "Expense date is required")
        @PastOrPresent(message = "Expense date cannot be in the future")
        LocalDate expenseDate

) {
    public Expense toEntity(){
            Expense ex = new Expense();
            ex.setItemName(itemName);
            ex.setAmount(amount);
            ex.setCurrency(currency);
            ex.setDescription(description);
            ex.setExpenseDate(expenseDate);
            ex.setStoreLocation(storeLocation);

            return ex;

    }
}
