import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class demoDelete {
    public static void main(String[] args)  throws Exception{
        FileSystem fs = FSUtils.getFS();
        //Path 代表路径 boolean表示递归
        boolean flag =
        fs.delete(new Path("/park01/lib.zip"), true);
        System.out.println(flag?"删除成功":"删除失败");
        fs.close();
    }
}
