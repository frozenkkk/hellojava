package com;

import java.util.List;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceMonitorDataRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceMonitorDataResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceMonitorDataResponse.InstanceMonitorData;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse.Instance;
import com.aliyuncs.ecs.model.v20140526.DescribeRegionsRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeRegionsResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeRegionsResponse.Region;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @ClassName: EcsDemo.java
 * @Description: TODO(ECS)
 * @date 2015年10月8日 下午12:56:40
 * @version V1.0
 */
public class EcsDemo {

	private static String ALIYUN_ACCESS_KEY_ID 		= "n0jqqIh4selWXRn7";
	private static String ALIYUN_ACCESS_KEY_SECRET 	= "4QbOxmBk6s3cEZmSyi2dWW5anZm97w";
	
	public void getInstances(){
		DescribeInstancesRequest describe = new DescribeInstancesRequest();
	    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ALIYUN_ACCESS_KEY_ID, ALIYUN_ACCESS_KEY_SECRET);
	    IAcsClient client = new DefaultAcsClient(profile);
	    try {
	        DescribeInstancesResponse response = client.getAcsResponse(describe);
	        List<Instance> instances = response.getInstances();
	        for(Instance instance:instances){
	        	System.out.println(instance.getInstanceId());
	        }
	    }catch (ServerException e) {
	        e.printStackTrace();
	    } 
	    catch (ClientException e) {
	        e.printStackTrace();
	    }	
	}
	
	public void getMonitor(){
//		i-23iu3tqdn
//		i-230vovhfc
		DescribeInstanceMonitorDataRequest describe = new DescribeInstanceMonitorDataRequest();
		describe.setInstanceId("i-23iu3tqdn");
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ALIYUN_ACCESS_KEY_ID, ALIYUN_ACCESS_KEY_SECRET);
		IAcsClient client = new DefaultAcsClient(profile);
		try {
			DescribeInstanceMonitorDataResponse response = client.getAcsResponse(describe);
			List<InstanceMonitorData> instanceMonitorDatas = response.getMonitorData();
			for(InstanceMonitorData data:instanceMonitorDatas){
				System.out.println(data.getInstanceId());
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DescribeRegionsRequest describe = new DescribeRegionsRequest();
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ALIYUN_ACCESS_KEY_ID, ALIYUN_ACCESS_KEY_SECRET);
		IAcsClient client = new DefaultAcsClient(profile);
		try {
			DescribeRegionsResponse response = client.getAcsResponse(describe);
			List<Region> regions = response.getRegions();
			for(Region region:regions){
				System.out.println(region.getRegionId());
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}

	}
}
