package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fugle_realtime_java_sdk_core.dto.response.ResponseObject;
import com.example.fugle_realtime_java_sdk_core.tool.HttpTool;

@SpringBootTest
public class HttpToolImpTest {
	
	@Autowired
	HttpTool httpTool;
	
	@Test
	void getForObject() {
		String url = "https://api.fugle.tw/realtime/v0.3/intraday/chart?symbolId=2884&apiToken=demo";
		
		ResponseObject responseObject =  httpTool.getForObject(url);
		
		assertEquals(true, null!=responseObject);
	}
}
