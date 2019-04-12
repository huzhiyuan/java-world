package com.hzy.sparkon;

import com.alibaba.fastjson.JSON;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxy on 2018/8/7.
 */


public class SparkOnHdfs {
    public static void main(String[] args) {
        System.setProperty("user","hzy");
        SparkSession sparkSession = SparkSession.builder()
                .appName("Spark On ES By JavaAPI")
                .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .config("spark.rdd.compress", "true")
                //.master("yarn-cluster")
                .getOrCreate();

        JavaSparkContext jsc = JavaSparkContext.fromSparkContext(sparkSession.sparkContext());

        JavaRDD<String> javaRDD = jsc.textFile("hdfs://192.168.158.130:9000/godfather.txt");

        List<String> x = javaRDD.filter(r->r.contains("sa")).collect();
        System.out.println(x.size());
        //jsc.stop();
    }

}
