package com.n2.portal.service.impl;

import com.n2.portal.dao.ExpenseDateDao;
import com.n2.portal.dto.ExpenseDateDTO;
import com.n2.portal.model.expense.ExpenseDate;
import com.n2.portal.service.ExpenseDateService;
import com.n2.portal.utils.MessageI18N;
import com.n2.portal.utils.N2Date;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
@Service
@Transactional
public class ExpenseDateServiceImpl implements ExpenseDateService {

    @Autowired
    private ExpenseDateDao expenseDateDao;

    @Autowired
    private MessageI18N messageI18N;

    public List<ExpenseDateDTO> getDates(int month, int year) {
        Date endDate = N2Date.getFistDateOfMonth(month, year);
        Date startDate = N2Date.getLastDateOfMonth(month, year);
        String userId = N2Security.getUser();
        List<ExpenseDate> expenseDates = expenseDateDao.getAllDate(userId, endDate, startDate);
        int numFirst = N2Date.getDate(endDate);
        int numLast = N2Date.getDate(startDate);
        List<ExpenseDateDTO> dates = new ArrayList<ExpenseDateDTO>();
        ExpenseDateDTO dto = null;
        for (int i = numFirst; i <= numLast; i++) {
            dto = new ExpenseDateDTO();
            dto.setActive(false);
            dto.setDate(i);
            Date d1 = N2Date.newDate(year, month, i);
            dto.setFullDate(N2Date.convertDateToStringDefault(d1));
            dto.setDay(messageI18N.getKey(N2Date.getDayOfWeek(d1)));
            if (N2Date.compareDate(d1, new Date())) {
                dto.setActive(true);
            }
            dto.setValue(getValue(expenseDates, d1));
            dates.add(dto);
        }
        return dates;
    }

    private Double getValue(List<ExpenseDate> dates, Date date) {
        if (dates == null || dates.size() == 0) {
            return 0.0;
        }
        for (ExpenseDate d : dates) {
            if (N2Date.compareDate(d.getDate(), date)) {
                return d.getTotal();
            }
        }
        return 0.0;
    }
}
