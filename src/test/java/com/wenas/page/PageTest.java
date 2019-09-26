package com.wenas.page;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/24 0024 9:54
 */
public class PageTest {
    public static void main(String[] args) {
        int a = 0;
        int b = 5;
        int p = a / b;
        if (a % b != 0)
            p++;
        System.out.println(p);
    }
}
