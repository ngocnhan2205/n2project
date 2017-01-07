package com.n2.portal.controller;

import com.n2.portal.model.expense.SpendCategory;
import com.n2.portal.service.SpendCategoryService;
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
 * Created by buibichngoc on 1/2/2017.
 */
@RestController
@RequestMapping(value = "/n2/api")
public class SpendController {

    @Autowired
    private SpendService spendService;

    @Autowired
    private SpendCategoryService spendCategoryService;

    @RequestMapping(value = "/spend", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpendCategory> saveSpendCategory(@RequestParam("date") String date,
                                                           @RequestParam("name") String name) {
        Date d = N2Date.getInstance(N2Date.parseDate(date));
        return new ResponseEntity<SpendCategory>(spendCategoryService.save(name, d), HttpStatus.OK);
    }

    @RequestMapping(value = "/spend", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpendCategory>> getAll(@RequestParam("date") String date) {
        Date d = N2Date.getInstance(N2Date.parseDate(date));
        return new ResponseEntity<List<SpendCategory>>(spendService.getAllSpend(d), HttpStatus.OK);
    }

    @RequestMapping(value = "/spend/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpendCategory> updateSpendCategory(@PathVariable("id") Long id,
                                                             @RequestParam("name") String name) {
        return new ResponseEntity<SpendCategory>(spendCategoryService.update(id, name), HttpStatus.OK);
    }

    @RequestMapping(value = "/spend/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSpendCategory(@PathVariable("id") Long id) {
        spendCategoryService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
