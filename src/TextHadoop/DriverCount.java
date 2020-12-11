package TextHadoop;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//启动类
public class DriverCount {
    public static void main(String[] args) throws  Exception{
        //创建一个任务
        Job job = Job.getInstance();
        //设置启动类
        job.setJarByClass(DriverCount.class);
        //设置MapperClass
        job.setMapperClass(MapperCount.class);
        //设置ReduceClass
        job.setReducerClass(ReduceCount.class);
        //设置Mapper的输出数据格式
        job.setMapOutputKeyClass(Text.class); //key
        job.setMapOutputValueClass(IntWritable.class);//Value
        //设置Reduce的输出数据格式
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //读取文件
        FileInputFormat.setInputPaths(job,new Path("/TextHadoop/File.txt"));// 源文件
        //设置输出
        FileOutputFormat.setOutputPath(job,new Path("/TextHadoop/result")); // 生成的结果
        //启动任务
        job.waitForCompletion(true);
    }
}
