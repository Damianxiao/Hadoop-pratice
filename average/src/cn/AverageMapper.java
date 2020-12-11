package cn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

/*
计算平均成绩
mapper读取数据
key 偏移量
value: tom 69
 */
//extends 要进行参数的约定，否则重写的方法参数类型不符合   LongWritable, Text,为输入  Text IntWritable  为输出格式
public class AverageMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //获取value字符串
        //value tom 69
        String [] arr = value.toString().split(" ");
        //此时tom 为 key
        context.write(new Text(arr[0]),new IntWritable(Integer.parseInt(arr[1])));
    }
}
