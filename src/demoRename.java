import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class demoRename {
    public static void main(String[] args) throws Exception {
        FileSystem fs = FSUtils.getFS();
        boolean flag =
        fs.rename(new Path("/park02"),new Path("/park03"));
        System.out.println(flag?"修改成功":"修改失败");
        fs.close();
    }
}
