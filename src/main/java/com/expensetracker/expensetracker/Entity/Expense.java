package com.expensetracker.expensetracker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="itemName",nullable = false)
    private String itemName;

    @Column(name="amount",nullable = false)
    private BigDecimal amount;

    @Column(name="currency",nullable = false)
    private String currency;

    @Column(name="store",nullable = false)
    private String storeLocation;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="expenseDate",nullable = false)
    private LocalDate expenseDate;

}
