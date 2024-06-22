package org.example.projectspringfalling._core.utils;

import java.util.LinkedHashSet;
import java.util.List;

public class ArrayUtil {

    // String 리스트에서 중복 제거 및 쉼표로 구분
    public static String removeDuplicates(List<String> duplicates) {
        return String.join(", ", new LinkedHashSet<>(duplicates));
    }
}
