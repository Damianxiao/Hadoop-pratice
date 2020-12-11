import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;

public class FSUtils {
    public static FileSystem getFS() throws  Exception{
        Configuration conf = new Configuration();
        return FileSystem.get(new URI("hdfs://192.168.56.128:9000"),conf);
    }
}
