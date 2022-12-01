package com.learning.springjpa.product.data.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeGen {
    public static String customerIdGenerator(String prefix){
        SimpleDateFormat dtf = new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();
        return prefix + dtf.format(date);
    }
}
