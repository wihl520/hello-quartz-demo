package com.wenas.imgCompress.until;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>Description: </p>
 * 压缩图片文件
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/18 0018 22:56
 */
public class ImgCompressTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<String> fileNameList = new  ArrayList<String>();
        String path = "D:/ProjectTest/surroundingLivePictures/images";
        fileNameList = getAllFileName(path, fileNameList);
        for (String fileName : fileNameList) {
            System.out.println(fileName);
            String StringMin = fileName.replace("images", "images4");
            try {
                Thumbnails.of(fileName)
                        .scale(1f)
                        .outputQuality(0.1f)
                        .toFile(StringMin);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            File file = new File(fileName);
//            try {
//                String StringMin = fileName.replace("images2", "images3");
//                ImgCompress imgCompress = new ImgCompress(file);
//                int height = imgCompress.getHeight();
//                int width = imgCompress.getWidth();
//                imgCompress.setDestFile(StringMin);
//                imgCompress.resizeFix(width, height);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


        }
        System.out.println("压缩时间: " + (System.currentTimeMillis() - start) / 1000.0);

    }

    /**
     * 获取某个文件夹下的所有文件
     *
     * @param fileNameList 存放文件名称的list
     * @param path 文件夹的路径
     * @return
     */
    public static ArrayList<String> getAllFileName(String path, ArrayList<String> fileNameList) {
        ArrayList<String> files = new ArrayList<String>();
        boolean flag = false;

        File file = new File(path);
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length - 1; i++) {
            if (tempList[i].isFile()) {
                fileNameList.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
            }
        }
        return fileNameList;
    }
}
