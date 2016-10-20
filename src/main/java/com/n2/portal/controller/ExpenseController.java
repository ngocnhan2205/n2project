package com.n2.portal.controller;

import com.n2.portal.dto.ExpenseDTO;
import com.n2.portal.model.expense.Expense;
import com.n2.portal.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dhnhan on 21/10/2016.
 */
@RestController
@RequestMapping("/n2/api")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @RequestMapping(value = "/expense",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Expense> save(@RequestBody ExpenseDTO expenseDTO) {
        return new ResponseEntity<Expense>(expenseService.saveExpense(expenseDTO), HttpStatus.CREATED);
    }
}
