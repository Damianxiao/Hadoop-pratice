import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class distinctDriver {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(distinctDriver.class);
        job.setMapperClass(distinctMapper.class);
        job.setReducerClass(distinctReduce.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.56.128:9000/distinct/distinct.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.56.128:9000/result/distinct"));
        job.waitForCompletion(true);
    }
}
