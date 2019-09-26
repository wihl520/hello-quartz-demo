package com.wenas.stringTest;

import java.io.File;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/25 0025 19:55
 */
public class StringTest {
    public static void main(String[] args) {
//        String a = "123";
//        boolean contains = a.contains("1");
//        System.out.println(contains);
//        File file = new File("D:/ProjectTest/111/");
//        boolean delete = file.delete();
//        System.out.println(delete);

        String lon = "113.54287719307467";
        String lat = "22.806567096408216";

        StringBuffer videoRecentlySql = new StringBuffer();
        videoRecentlySql.append("SELECT a.lon, a.lat, a.id, St_distance ( 'POINT(");
        videoRecentlySql.append(lon + " ");
        videoRecentlySql.append(lat);
        videoRecentlySql.append(")', ST_PointFromText ( 'POINT(' || lon || ' ' || lat || ')' )) * 60 * 1.852 AS distance FROM w_poi AS a");
        videoRecentlySql.append(" WHERE a.status = 1 AND A.syncstatus != 'D' AND A.poi_type LIKE 'VIDEO%' ORDER BY distance LIMIT 1");
        System.out.println(videoRecentlySql.toString());
    }
}
