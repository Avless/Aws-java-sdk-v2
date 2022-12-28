package com.javaawssdk;

import java.util.Date;
import java.util.List;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;

public class AwsCloudWatchMetrics {

    final static String InstanceId = "i-0fefde3ad000f72e4";

    public static void main(String[] args) {

        MonitorCPU();

    }
    public static void MonitorCPU() {

        // AmazonCloudWatchClient cw = new AmazonCloudWatchClient(credentials);

        AWSCredentialsProvider awsp = new AWSCredentialsProvider() {

            @Override
            public void refresh() {
                // TODO Auto-generated method stub

            }

            @Override
            public AWSCredentials getCredentials() {
                AWSCredentials awsCredentials = null;
                try {
                    awsCredentials = new AWSCredentials() {

                        public String getAWSSecretKey() {
                            return "SWeRZ2rtaMh5/YOinH4gB001kcGTrgrIhdienAbu";
                        }

                        public String getAWSAccessKeyId() {
                            return "AKIAXPGYLP6XAEWWSVG5";
                        }
                    };
                } catch (Exception e) {
                    throw new AmazonClientException(
                            "can not load your aws credentials, please check your credentials !!", e);
                }
                return awsCredentials;
            }
        };
        try{

            AmazonCloudWatch cw =  AmazonCloudWatchClientBuilder.standard()
                    .withCredentials(awsp).withRegion("us-east-1").build();
            long offsetInMilliseconds = 1000 * 60 * 60 * 24 * 21 ;

            Dimension dimension = new Dimension()
                    .withName("jahir")
                    .withValue("i-0790bd98d2c38a2ee");

            GetMetricStatisticsRequest request = new GetMetricStatisticsRequest()
                    .withStartTime(new Date(new Date().getTime() - offsetInMilliseconds)).withNamespace("AWS/EC2")
                    .withPeriod(60 * 60)
                    .withMetricName("CPUUtilization").withStatistics("Average").withEndTime(new Date())
                    .withDimensions(dimension);
            GetMetricStatisticsResult getMetricStatisticsResult = cw.getMetricStatistics(request);

            System.out.println("request " + request.toString());
            System.out.println("label : " + getMetricStatisticsResult.getLabel());
            System.out.println("DataPoint Size : " + getMetricStatisticsResult.getDatapoints().size());

            double avgCPUUtilization = 0;
            List<Datapoint> dataPoint = getMetricStatisticsResult.getDatapoints();
            for (Object aDataPoint : dataPoint) {
                Datapoint dp = (Datapoint) aDataPoint;
                System.out.println(" avgCPUUtilization " + avgCPUUtilization);
            }

        }catch(AmazonServiceException ase){

            ase.printStackTrace();
        }

    }
}     