package com.wenas.ftpTest;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.UUID;
import java.util.Vector;

/**
 * <p>Description: </p>
 * 测试修改提交
 * @author Wenas
 * @version 1.0.0
 * @date 2019/4/29 0029 21:08
 */
public class FtpJSch {
    /**
     <property name="laserRadarSource" value="39.108.15.72" /> <!-- 数据源 IP 地址 -->
     <property name="laserRadarPort" value="21" /> <!-- FTP 端口 -->
     <property name="laserRadarUserName" value="root" /> <!-- FTP 用户名 -->
     <property name="laserRadarPassword" value="123456" /> <!-- FTP 密码 -->
     <property name="laserRadarFtpDir" value="/Ftpfile/root/images/" /> <!-- 上传到指定 FTP 文件的路径 -->
     **/
    private static ChannelSftp sftp = null;

    //主机ip
    private static String host =  "39.108.15.72";
    //端口
    private static int port = 21;
    //账号
    private static String user = "root";
    //密码
    private static String password = "123456";
    //上传地址
    private static String directory = "/Ftpfile/root/images/";
    //下载目录
    private static String saveFile = "D:\\VMware\\XuNiJi\\imgs";

    public static FtpJSch getConnect(){
        FtpJSch ftp = new FtpJSch();
        try {
            JSch jsch = new JSch();

            //获取sshSession  账号-ip-端口
            Session sshSession =jsch.getSession(user, host,port);
            //添加密码
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");

            sshSession.setConfig(sshConfig);
            //开启sshSession链接
            sshSession.connect();
            //获取sftp通道
            Channel channel = sshSession.openChannel("sftp");
            //开启
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     *
     * @param uploadFile 上传文件的路径
     * @return 服务器上文件名
     */
    public String upload(String uploadFile) {
        File file = null;
        String fileName = null;
        try {
            sftp.cd(directory);
            file = new File(uploadFile);
            //获取随机文件名
            fileName  = UUID.randomUUID().toString() + file.getName().substring(file.getName().length()-5);
            //文件名是 随机数加文件名的后5位
            sftp.put(new FileInputStream(file), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file == null ? null : fileName;
    }

    /**
     * 下载文件
     *
     *  directory    下载目录
     *
     *  downloadFile 下载的文件名
     *
     *  saveFile     存在本地的路径
     *
     *  sftp
     */
    public void download(String downloadFileName) {
        try {
            sftp.cd(directory);

            File file = new File(saveFile);

            sftp.get(downloadFileName, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param deleteFile
     *            要删除的文件名字
     *  sftp
     */
    public void delete(String deleteFile) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory
     *            要列出的目录
     *  sftp
     * @return
     * @throws SftpException
     */
    public Vector listFiles(String directory)
            throws SftpException {
        return sftp.ls(directory);
    }

}
