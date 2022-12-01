package com.learning.springjpa.product.data.TestCodes;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestClass {
    public static void main(String[] args) {
        System.out.println(datetime());
    }

    public static String datetime(){
        final String transactionPrefix = "TRN";
        SimpleDateFormat dtf = new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();
        return transactionPrefix + dtf.format(date);
    }

}
