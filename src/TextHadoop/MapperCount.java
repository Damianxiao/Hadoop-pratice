package TextHadoop;/*
mapper组件以文件的偏移量为key , 行为value
mapper将文件中的数据一行一行输出


 */

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapperCount extends Mapper<LongWritable,Text, Text, IntWritable> {
    //LongWrite 偏移量
    //Text 行
    //输出(可以自己指定) 文本 数值 Text IntWritable
    //业务方法

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //key 行号
        //value 每一行内容
        //context 写出数据
        //将text转成String
        String line = value.toString();
        String [] arr = line.split(" ");
        for (String str : arr){
            context.write(new Text(str),new IntWritable(1));
        }
        /*
        输出:
        hello 1
        hello 1
        java 1

         */
    }
}



