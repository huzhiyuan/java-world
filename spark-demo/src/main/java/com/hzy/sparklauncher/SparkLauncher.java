package com.hzy.sparklauncher;

import org.apache.spark.launcher.SparkAppHandle;

import java.util.HashMap;

/**
 * Created by wangxy on 2018/7/30.
 */


public class SparkLauncher {
    public static void main(String[] args) throws Exception {
        System.setProperty("SPARK_HOME", "C:\\server\\spark-2.4.0-bin-hadoop2.7\\");
        System.setProperty("hadoop.home.dir", "C:\\server\\hadoop-2.7.7\\");

        String projectPath = "C:\\java-space\\java-world\\spark-demo\\";
        String filePath = projectPath+"target";
        //"/Users/haizhi/IdeaProjects/SparkLauncher/target/";

        HashMap<String, String> env = new HashMap<String, String>(2);
        //提交服务器路径地址
/*        env.put("HADOOP_CONF_DIR", "/Users/haizhi/IdeaProjects/lab/lab-hdp/src/main/resource");
        env.put("YARN_CONF_DIR", "/Users/haizhi/IdeaProjects/lab/lab-hdp/src/main/resource");*/
        env.put("HADOOP_CONF_DIR", projectPath+"/src/main/resources");
        env.put("YARN_CONF_DIR", projectPath+"/src/main/resources");

        SparkAppHandle handle = new org.apache.spark.launcher.SparkLauncher(env)
                // Process spark = new SparkLauncher(env)
                .setAppResource(filePath + "/spark-jobs-jar-with-dependencies.jar")
                .setMainClass("com.hzy.sparkon.SparkOnHdfs")
                .setMaster("yarn")
                .setDeployMode("cluster")
                .setSparkHome("C:\\server\\spark-2.4.0-bin-hadoop2.7\\")
                .setAppName("Spark On Hive By HDP")
                .setConf(org.apache.spark.launcher.SparkLauncher.DRIVER_MEMORY, "1g")
                .setConf(org.apache.spark.launcher.SparkLauncher.EXECUTOR_CORES, "4")
                .setConf(org.apache.spark.launcher.SparkLauncher.EXECUTOR_MEMORY, "1g")
                .setConf("spark.cores.max", "40")
                //.setAppResource("C:\\java-space\\java-world\\spark-demo/src/main/resource/hbase-site.xml")
                //.setConf("spark.yarn.jars", "hdfs://192.168.1.16:8020/user/graph/lib/spark2x.jars/*")
                //.addAppArgs("{\"outputHBaseTable\":\"to_sim_product\",\"namespace\":\"crm_dev2\",\"tagTable\":\"tag_value\",\"productTable\":\"tv_account\",\"code\":1}")
                .startApplication();

        while (handle.getState() != SparkAppHandle.State.FINISHED) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("applicationId is: " + handle.getAppId());
            System.out.println("current state: " + handle.getState());
//            handle.stop();
        }
    }
}
