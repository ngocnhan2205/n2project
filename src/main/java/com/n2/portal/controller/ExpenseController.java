package com.n2.portal.controller;

import com.n2.portal.dto.ExpenseDateDTO;
import com.n2.portal.service.ExpenseDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
@RestController
@RequestMapping("/n2/api")
public class ExpenseController {

    @Autowired
    private ExpenseDateService expenseDateService;

    @RequestMapping(value = "/expense", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExpenseDateDTO>> getExpenses(@RequestParam("year") int year,
                                                            @RequestParam("month") int month) {
        return new ResponseEntity<List<ExpenseDateDTO>>(expenseDateService.getDates(month, year), HttpStatus.OK);
    }
}
