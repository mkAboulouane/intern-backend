package fst.sir.stage_back.service.util;

public class StringUtil {
    private static Long i=100L;
    public static Long codeApogesIncrement()
    {
        return ++i;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isNotEmpty(Object value) {
        return value != null && !isEmpty(value.toString());
    }


}
