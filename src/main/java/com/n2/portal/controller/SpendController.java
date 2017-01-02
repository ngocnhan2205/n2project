package com.n2.portal.controller;

import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by buibichngoc on 1/2/2017.
 */
@RestController
@RequestMapping(value = "/n2/api")
public class SpendController {

    @Autowired
    private SpendService spendService;

    @RequestMapping(value = "/spend", method = RequestMethod.POST)
    public ResponseEntity<Void> saveSpend(@RequestParam("date") String date,
                                          @RequestParam("name") String name) {
        Date d = N2Date.getInstance(N2Date.parseDate(date));
        spendService.saveSpend(name, d);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
