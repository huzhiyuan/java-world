package com.hzy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HdfsClient {

    private static Configuration conf;
    FileSystem fs;

    /**
     * 初始化FileSystem
     */
    @Before
    public void init() throws Exception {
        conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.158.130:9000");


        // 如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是hadoop用户
        //fs = FileSystem.get(new URI("hdfs://192.168.158.130:9000"), conf, "hzy");
    }

    /**
     * 往hdfs上传文件
     */
    @Test
    public void testAddFileToHdfs() throws Exception {
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.158.130:9000"), conf, "hzy");
        // 要上传的文件所在的本地路径
        Path src = new Path("c:/datas/godfather.txt");
        // 要上传到hdfs的目标路径
        Path dst = new Path("/");
        fs.copyFromLocalFile(src, dst);

        fs.close();
    }

    /**
     * 从hdfs中复制文件到本地文件系统
     */
    @Ignore
    @Test
    public void testDownloadFileToLocal() throws IllegalArgumentException, IOException {
        fs.copyToLocalFile(new Path("/jdk-7u65-linux-i586.tar.gz"), new Path("d:/"));
        fs.close();
    }

    /**
     * 在hfds中创建目录、删除目录、重命名
     */
    @Ignore
    @Test
    public void testMkdirAndDeleteAndRename() throws IllegalArgumentException, IOException {
        // 创建目录
        fs.mkdirs(new Path("/a1/b1/c1"));

        // 删除文件夹 ，如果是非空文件夹，参数2必须给值true
        fs.delete(new Path("/aaa"), true);

        // 重命名文件或文件夹
        fs.rename(new Path("/a1"), new Path("/a2"));
    }

    /**
     * 查看目录信息，只显示文件
     */
    @Ignore
    @Test
    public void testListFiles() throws FileNotFoundException, IllegalArgumentException, IOException {
        // 思考：为什么返回迭代器，而不是List之类的容器
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();

            System.out.println(fileStatus.getPath().getName());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getLen());
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation bl : blockLocations) {
                System.out.println("block-length:" + bl.getLength() + "--" + "block-offset:" + bl.getOffset());
                String[] hosts = bl.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }
            }
            System.out.println("--------------分割线--------------");
        }
    }

    /**
     * 查看文件及文件夹信息
     */
    @Ignore
    @Test
    public void testListAll() throws FileNotFoundException, IllegalArgumentException, IOException {
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        String flag = "d--             ";

        for (FileStatus fstatus : listStatus) {
            if (fstatus.isFile())
                flag = "f--         ";
            System.out.println(flag + fstatus.getPath().getName());
        }
    }
}