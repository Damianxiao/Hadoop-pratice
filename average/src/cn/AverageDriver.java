package cn;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/*
启动类
 */
public class AverageDriver {
    public static void main(String[] args) throws  Exception{
        //new job
        Job job = Job.getInstance();
        //启动类
        job.setJarByClass(AverageDriver.class);
        //Mapper
        job.setMapperClass(AverageMapper.class);
        //Reduce
        job.setReducerClass(AverageReduce.class);
        //设置Mapper的输出数据格式
        job.setMapOutputKeyClass(Text.class); //key
        job.setMapOutputValueClass(IntWritable.class);//Value
        //设置Reduce的输出数据格式
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        //读取文件
        FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.56.128:9000/average/average.txt"));// 源文件
        //设置输出
        FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.56.128:9000/result/average")); // 生成的结果
        //启动任务
        job.waitForCompletion(true);
    }
}
