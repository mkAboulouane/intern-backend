package com.example.stage_back.util;

import java.util.List;

public class ListUtil {

    public static boolean isEmpty(List objects) {
        return objects == null || objects.isEmpty();
    }

    public static boolean isNotEmpty(List objects) {
        return !isEmpty(objects);
    }

}
