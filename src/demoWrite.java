import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URI;

public class demoWrite {
    public static void main(String[] args) throws  Exception {
        //本地内容上传至hdfs服务器存储系统中
        Configuration conf = new Configuration();
        FileSystem fs= FileSystem.get(new URI("hdfs://192.168.56.128:9000"),conf);
        //通过读入输入流读取本地路径
        FileInputStream fis = new FileInputStream("resource/lib.zip");
        //输出流，写入hdfs文件系统中
        OutputStream os  =
        fs.create(new Path("/park01/lib.zip"));
        //字节流，
        IOUtils.copyBytes(fis,os,conf);
        System.out.println("写入完毕");
        fis.close();
        os.close();
        fs.close();
    }
}
