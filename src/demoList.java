import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class demoList {
    public static void main(String[] args) throws Exception {
        //获取文件系统
        FileSystem fs = FSUtils.getFS();
        //locatedFileStatus 是迭代器
        RemoteIterator<LocatedFileStatus> it = fs.listFiles(new Path("/park01"),true);//第一个参数是目录，第二个是递归
        //使用迭代器：1问 2取 3操作
        while(it.hasNext()){
            LocatedFileStatus lfs = it.next();
            System.out.println(lfs.getPath());
        }
        System.out.println("读取完毕");
    }
}
