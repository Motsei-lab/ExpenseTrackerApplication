package com.expensetracker.expensetracker.Controllers;

import com.expensetracker.expensetracker.DTOs.ExpenseRequest;
import com.expensetracker.expensetracker.DTOs.ExpenseResponse;
import com.expensetracker.expensetracker.Service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping()
    public ResponseEntity<ExpenseResponse> create(@Valid @RequestBody ExpenseRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.create(request));
    }

    @GetMapping
    public List<ExpenseResponse>cgetAll(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ExpenseResponse getById(@PathVariable Long id){
        return expenseService.getEpenseById(id);
    }

    @PutMapping("/{id}")
    public ExpenseResponse update (@PathVariable Long id, @Valid @RequestBody ExpenseRequest request){
        return expenseService.update(request,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        expenseService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
