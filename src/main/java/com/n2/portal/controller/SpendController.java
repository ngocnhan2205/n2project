package com.n2.portal.controller;

import com.n2.portal.dto.SpendDTO;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/spend", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spend> saveSpend(@RequestParam("date") String date,
                                           @RequestParam("name") String name) {
        Date d = N2Date.getInstance(N2Date.parseDate(date));
        return new ResponseEntity<Spend>(spendService.saveSpend(name, d), HttpStatus.OK);
    }

    @RequestMapping(value = "/spend", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpendDTO>> getAll(@RequestParam("date") String date) {
        Date d = N2Date.getInstance(N2Date.parseDate(date));
        return new ResponseEntity<List<SpendDTO>>(spendService.getAllSpend(d), HttpStatus.OK);
    }
}