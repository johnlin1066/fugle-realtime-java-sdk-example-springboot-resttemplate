package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.fugle_realtime_java_sdk_core.FugleRealtime;
import com.example.fugle_realtime_java_sdk_core.FugleRealtimeImp;
import com.example.fugle_realtime_java_sdk_core.tool.HttpTool;
import com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool.HttpToolImp;

@SpringBootApplication
public class FugleRealtimeJavaSdkExampleSpringbootResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(FugleRealtimeJavaSdkExampleSpringbootResttemplateApplication.class, args);
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public FugleRealtime fugleRealtime(HttpTool httpTool) {
		return new FugleRealtimeImp(httpTool);
	}
	@Bean
	public HttpTool httpTool(RestTemplate restTemplate) {
		return new HttpToolImp(restTemplate);
	}

}
