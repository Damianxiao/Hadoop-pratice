import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class demoBlock {
    public static void main(String[] args) throws  Exception{
        //测试文件切块大小
        FileSystem fs = FSUtils.getFS();
        //参数1 路径 参数2 开始值 参数3 最大值

        //返回值有多块，应该为一个数组
        BlockLocation [] bl =
        fs.getFileBlockLocations(new Path("/park01/lib.zip"),0,Integer.MAX_VALUE);

        for (BlockLocation bls :bl){
            System.out.println(bls);
        }

    }
}
