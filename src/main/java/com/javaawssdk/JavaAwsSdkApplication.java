package com.javaawssdk;



import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;



@SpringBootApplication
public class JavaAwsSdkApplication  {
	public static void main(String[] args) {
		Logger root=(Logger) LoggerFactory.getILoggerFactory().getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.ERROR);
		
		ListUsers.main(args);
		DescribeInstances.main(args);
		S3BucketOps.main(args);
		
			
	
		
	}

}
