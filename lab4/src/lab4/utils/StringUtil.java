package lab4.utils;

public final class StringUtil {

    private StringUtil() {
        // No operations.
    }

    public static boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isNotNullOrBlank(String s) {
        return !isNullOrBlank(s);
    }
}
