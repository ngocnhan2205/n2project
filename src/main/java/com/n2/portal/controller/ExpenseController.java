package com.n2.portal.controller;

import com.n2.portal.dto.ExpenseDTO;
import com.n2.portal.model.expense.Expense;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.service.ExpenseService;
import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by dhnhan on 21/10/2016.
 */
@RestController
@RequestMapping("/n2/api")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    SpendService spendService;

    @RequestMapping(value = "/expense", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Expense> save(@RequestBody ExpenseDTO expenseDTO) {
        return new ResponseEntity<Expense>(expenseService.saveExpense(expenseDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/expense", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Expense>> getAllByUser(@RequestParam("gran") String gran,
                                                      @RequestParam("date") String strDate) {
        Date date = N2Date.parseDate(strDate);
        return new ResponseEntity<List<Expense>>(expenseService.getExpenses(date, gran), HttpStatus.OK);
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Expense> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<Expense>(expenseService.deleteExpense(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/spend/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Expense> addSpend(@PathVariable("id") Long id,
                                            @RequestParam("gran") String gran,
                                            @RequestBody Spend spend) {
        Expense expense = expenseService.getExpense(id);
        spend.setExpense(expense);
        Spend s = spendService.saveSpend(spend);
        Expense e = expenseService.getExpense(id, s.getDateSpend(), gran);
        return new ResponseEntity<Expense>(e, HttpStatus.OK);
    }
}
