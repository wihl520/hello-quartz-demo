package com.wenas.fileDir;

import net.coobird.thumbnailator.Thumbnails;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * 将制定目录下的所有gif png jpg 图片压缩到当前文件夹的 compressedFolder
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/25 0025 18:00
 */
public class FileDir {
    public static void main(String[] args) {
        String geololgyFileDir = "D:/ProjectTest/20190422/test/";
        compressedFolderImages(geololgyFileDir);
    }

    /**
     * 压缩文件夹下所有的图片，并存放在当前文件夹下的 compressedFolder 中
     * @param geololgyFileDir 文件夹地址
     */
    private static void compressedFolderImages(String geololgyFileDir) {
        String geololgyFileDirMin = geololgyFileDir + "/compressedFolder/";
        File file = new File(geololgyFileDirMin);
        if (!file.exists()) {
            file.mkdirs();
        }
        Map<String, List<String>> fileListHashMap = new HashMap<>();
        List<String> fileNameList = new ArrayList<>();
        List<String> absoluteFileNameList = new ArrayList<>();
        fileListHashMap.put("fileNameList", fileNameList);
        fileListHashMap.put("absoluteFileNameList", absoluteFileNameList);
        fileListHashMap = getFileNameMap(geololgyFileDir, fileListHashMap);
        fileNameList = fileListHashMap.get("fileNameList");
        absoluteFileNameList = fileListHashMap.get("absoluteFileNameList");
        try {
            for (int i = 0; i <= absoluteFileNameList.size() - 1; i++) {
                String fileNameDir = geololgyFileDirMin + fileNameList.get(i);
                Thumbnails.of(absoluteFileNameList.get(i))
                        .scale(1f)
                        .outputQuality(0.1f)
                        .toFile(fileNameDir);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取某个文件夹下的所有名绝对路径,只读取出 jpg png git 压缩
     *
     * @param path         遍历文件夹的路径
     * @param fileNameMap  存放文件名称和绝对路径的map
     * @return
     */
    public static Map<String, List<String>> getFileNameMap(String path, Map<String, List<String>> fileNameMap) {
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (int i = 0; i <= tempList.length - 1; i++) {
            if (tempList[i].isFile()) {
                // 文件名称
                String name = tempList[i].getName();
                if (name.contains(".jpg") || name.contains(".png") || name.contains(".gif")) {
                    // 文件绝对路径
                    String fileNameDirName = tempList[i].toString();
                    List<String> fileNameList =  fileNameMap.get("fileNameList");
                    List<String> absoluteFileNameList =  fileNameMap.get("absoluteFileNameList");
                    fileNameList.add(name);
                    absoluteFileNameList.add(fileNameDirName);
                }
            }
            if (tempList[i].isDirectory()) {
                getFileNameMap(tempList[i].getAbsolutePath(), fileNameMap);
            }
        }
        return fileNameMap;
    }
}
