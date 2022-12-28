package com.javaawssdk;

	import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
	import software.amazon.awssdk.regions.Region;
	import software.amazon.awssdk.services.ec2.Ec2Client;
	import software.amazon.awssdk.services.ec2.model.DescribeSecurityGroupsResponse;
	import software.amazon.awssdk.services.ec2.model.SecurityGroup;

	
	public class ListOfSecurityGroup {

		public void getAllSecurityGroup(){
		       
		    	   Region region = Region.US_EAST_1;
		 	      Ec2Client ec2 = Ec2Client.builder()
		 	          .region(region)
		 	          .credentialsProvider(ProfileCredentialsProvider.create())
		 	          .build();
		           DescribeSecurityGroupsResponse response = ec2.describeSecurityGroups();
		           System.out.println("-----------------------------------------------------------------------------------------------------");
				    System.out.printf(" | %-23s| %-21s | %-47s |%n", "security group","vpc id","description");
		           for(SecurityGroup group : response.securityGroups()) {
		        	   System.out.println("-----------------------------------------------------------------------------------------------------");
				    	 System.out.printf(" | %-23s| %-15s | %-47s |%n", group.groupId(),group.vpcId(),group.description());
				      } 
		            System.out.println("------------------------------------------------------------------------------------------------------");
    
		  }
	}


