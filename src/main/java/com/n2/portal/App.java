package com.n2.portal;

import com.n2.portal.utils.N2Date;

/**
 * Created by dhnhan on 9/27/2016.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(N2Date.getDate(N2Date.getLastDateOfMonth(0, 2017)));
    }
}
