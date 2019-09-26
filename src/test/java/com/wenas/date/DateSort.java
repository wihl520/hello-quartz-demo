package com.wenas.date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/30 0030 1:15
 */
public class DateSort {

    public static void main(String[] args) {

        List<String> list =new ArrayList<String>();
        list.add("2014-09-04 10:34:41");
        list.add("2013-08-04 13:42:19");
        list.add("2014-09-04 16:46:49");
        list.add("2010-01-04 12:32:00");
        list.add("2004-04-04 10:34:41");
        list.add("2009-05-14 23:42:19");
        list.add("2014-12-04 06:08:49");
        list.add("2010-01-24 01:32:00");
        System.out.println(list);
        Collections.sort(list);
        for (String str : list) {
            System.out.println(str);
        }


    }
}

