package com.wenas.ftpTest;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/29 0029 21:07
 */
public class FtpTest {
    public static void main(String[] args) {

        FtpJSch connect = FtpJSch.getConnect();

        String upload = connect.upload("C:\\Users\\Administrator\\Desktop\\vsftpd.conf.txt");

        System.out.println(upload);
    }
}
