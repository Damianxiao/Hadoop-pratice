import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;

//通过程序能连接上hadoop
public class demoFilename {
    public static void main(String[] args) throws Exception {
        //创建环境
        Configuration conf = new Configuration();
        //创建文件系统 通过namenode 获取文件
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.56.128:9000"), conf);
        System.out.println("fs=" + fs);
        fs.close();
    }
}

