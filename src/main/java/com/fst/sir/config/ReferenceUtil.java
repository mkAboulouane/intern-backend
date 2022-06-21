package com.fst.sir.config;

public class ReferenceUtil {
    private static Long indice = 10000L;
    public static Long generateReference(){
        return ++indice;
    }

}
