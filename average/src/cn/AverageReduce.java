package cn;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

//输入格式是从mapper传来的Text IntWritable  输出也是
public class AverageReduce extends Reducer<Text, IntWritable, Text, DoubleWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //将相同的key 合并
        //tom  [69,89]
        //处理values
        Iterator<IntWritable> it = values.iterator();
        double sum = 0;// 成绩
        int count = 0;//科目
        while (it.hasNext()) {
            IntWritable num = it.next();
            sum += num.get();
            count++;
        }
        //保留小数点后两位
        double result = sum / count;
        result = (int) (result * 100 + 0.5) / 100.0;
        //保留两位小数：除100 一位除10 但都是加0.5
        context.write(key,new DoubleWritable(result));
    }
}
