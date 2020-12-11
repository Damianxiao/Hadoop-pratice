import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;

public class demoDownload {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.56.128:9000"),conf);

        InputStream in  = fs.open(new Path("/park01/javase011.jar"));
        FileOutputStream fos = new FileOutputStream("./javase011.jar");
        IOUtils.copyBytes(in,fos,conf);
        System.out.println("下载完成");
        in.close();
        fos.close();
    }
}
