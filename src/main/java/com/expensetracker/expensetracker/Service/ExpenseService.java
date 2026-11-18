package com.expensetracker.expensetracker.Service;

import com.expensetracker.expensetracker.DTOs.ExpenseRequest;
import com.expensetracker.expensetracker.DTOs.ExpenseResponse;
import com.expensetracker.expensetracker.Entity.Expense;
import com.expensetracker.expensetracker.Exceptions.ExpenseNotFoundException;
import com.expensetracker.expensetracker.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseResponse create(ExpenseRequest request) {
        Expense saved = expenseRepository.save(request.toEntity());
        return ExpenseResponse.fromEntity(saved);
    }

    public List<ExpenseResponse> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .map(ExpenseResponse::fromEntity).toList();
    }

    public ExpenseResponse getEpenseById(Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow(()-> new ExpenseNotFoundException(id));
        return ExpenseResponse.fromEntity(expense);
    }

    public ExpenseResponse update(ExpenseRequest request, Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow(()-> new ExpenseNotFoundException(id));

        expense.setItemName(request.itemName());
        expense.setAmount(request.amount());
        expense.setCurrency(request.currency());
        expense.setStoreLocation(request.storeLocation());
        expense.setDescription(request.description());
        expense.setExpenseDate(request.expenseDate());

        Expense updated = expenseRepository.save(expense);
        return ExpenseResponse.fromEntity(updated);
    }

    public void delete(Long id){
        if(!expenseRepository.existsById(id)){
            throw new ExpenseNotFoundException(id);
        }
        expenseRepository.deleteById(id);
    }
}
