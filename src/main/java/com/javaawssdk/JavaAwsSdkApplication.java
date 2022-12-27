package com.javaawssdk;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaAwsSdkApplication  {
	public static void main(String[] args) {
		
		ListUsers.main(args);
		DescribeInstances.main(args);
		S3BucketOps.main(args);
		
			
	
		
	}

}
