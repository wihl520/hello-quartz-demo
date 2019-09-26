package com.wenas.map;

import org.apache.tomcat.util.http.ResponseUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/19 0019 16:10
 */
public class MapTest {
    public static void main(String[] args) {
//        Test1();
        Map<String, Object> map = new HashMap<>();
        map.put("1", "111");
        map.put("2", "222");
        System.out.println(map);
        map.put("2", "22");
        System.out.println(map);
    }

    private static void Test1() {
        HashMap map = new HashMap();
        map.put("1", "value1");
        map.put("2", "value2");
        Iterator keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = (String)keys.next();
            if("2".equals(key)){
                System.out.println("存在key");
            }
        }
        boolean flag=map.containsKey("1");
        System.out.println(flag);
    }

}
