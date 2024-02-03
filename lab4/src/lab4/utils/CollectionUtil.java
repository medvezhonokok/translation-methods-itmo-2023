package lab4.utils;

import java.util.ArrayList;
import java.util.List;

public final class CollectionUtil {

    private CollectionUtil() {
        // No operations.
    }

    public static List<String> getNonEmptyTrimmedStringList(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (StringUtil.isNotNullOrBlank(s)) {
                result.add(s.trim());
            }
        }
        return result;
    }
}
