package TextHadoop;/*
对Mapper输出的内容再加工
Mapper :
Text   IntWritable
hello   1
hello   1
java    1
Spring 1
合并后：
hello[1,1]
java[1]
 */

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class ReduceCount extends Reducer <Text, IntWritable,Text,IntWritable>{
    //hello 5
    //java 1
    @Override
    //Reduce 负责处理 hello[1,1,1]
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //key Mapper输出的key ::      hello hello
        //values 合并所有相同key后，将value 作为一个迭代器输出
        //context 输出
        int sum = 0;
        Iterator<IntWritable> it = values.iterator();//获取迭代器
        while((it).hasNext()){  // 有没有下一个?
            IntWritable num = it.next();   // 取值
            sum+= num.get();
        }
        //通过context上下文写出内容
        context.write(key,new IntWritable(sum));
        //hello 4
        //java 2
    }
}
