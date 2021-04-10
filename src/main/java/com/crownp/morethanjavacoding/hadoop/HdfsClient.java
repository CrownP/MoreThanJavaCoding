package com.crownp.morethanjavacoding.hadoop;

import com.alibaba.fastjson.JSON;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Hadoop的一些Java Api的使用方法
 * @Author qgp
 * @Date 2019/10/28 17:32
 **/
public class HdfsClient {

    /**
     * 创建目录
     */
    public static void testMkdirs() throws URISyntaxException, IOException, InterruptedException {
        //1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://10.0.0.20:9000"), configuration, "root");

        //2创建目录
        //fileSystem.mkdirs(new Path("/usr/test2"));
        FileStatus[] fileStatus = fileSystem.listStatus(new Path("/usr/test2"));
        for (FileStatus fileStatus1:fileStatus){
            System.out.println("-----------------");
            Map<String,Object> map = new HashMap();
            map.put("fileName",fileStatus1.getPath().getName());
            System.out.println(JSON.toJSONString(map));
            System.out.println("-----------------");
        }


        //3关闭资源
        fileSystem.close();
    }

    /**
     * 文件上传
     */
    public static void testUpload() throws URISyntaxException, IOException, InterruptedException {
        //1 获取文件系统
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "2");
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://10.0.0.20:9000"), configuration, "root");

        //2 上传文件
        fileSystem.copyFromLocalFile(new Path("F:/学习视频/1.笔记/尚硅谷大数据技术之Hadoop（HDFS).docx"),
                new Path("/usr/test2"));

        //3 关闭资源
        fileSystem.close();
    }


    /**
     * 文件下载
     */
    public static void testDownload() throws IOException, URISyntaxException, InterruptedException {
        //1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://10.0.0.20:9000"), configuration, "root");

        //2 执行下载操作
        // boolean delSrc 指是否将原文件删除
        // Path src 指要下载的文件路径
        // Path dst 指将文件下载到的路径
        // boolean useRawLocalFileSystem 是否开启文件校验
        fileSystem.copyToLocalFile(false, new Path("/usr/test2/尚硅谷大数据技术之Hadoop（HDFS).docx"),
                new Path("C:/Users/qingu/Desktop/尚硅谷大数据技术之Hadoop（HDFS).docx"), true);

        //3 关闭资源
        fileSystem.close();

    }

    public static List<HashMap<String,Object>> getFile(String url) throws IOException, URISyntaxException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://10.0.0.20:9000"), configuration, "root");
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path(url));
        List<HashMap<String,Object>> list = new ArrayList();
        for (FileStatus fileStatus:fileStatuses){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("FileName",fileStatus.getPath().getName());
            hashMap.put("url",fileStatus.getPath().toString());
            hashMap.put("user",fileStatus.getOwner());
            list.add(hashMap);
        }
        return list;
    }

}
