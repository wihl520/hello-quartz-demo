package com.wenas.list;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/25 0025 15:05
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        System.out.println(strings);
        Collections.reverse(strings); // 倒序排列
        System.out.println(strings);

    }
}
