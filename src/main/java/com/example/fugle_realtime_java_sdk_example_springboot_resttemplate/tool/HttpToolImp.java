package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool;

import org.springframework.web.client.RestTemplate;

import com.example.fugle_realtime_java_sdk_core.dto.response.ResponseObject;
import com.example.fugle_realtime_java_sdk_core.tool.HttpTool;

public class HttpToolImp implements HttpTool{
	
	RestTemplate restTemplate;
	
	public HttpToolImp(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public ResponseObject getForObject(String url) {
		return restTemplate.getForObject(url, ResponseObject.class);
	}

}
