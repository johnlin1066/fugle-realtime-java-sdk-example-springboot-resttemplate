package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.fugle_realtime_java_sdk_core.historical.HistoricalInteractors;
import com.example.fugle_realtime_java_sdk_core.historical.HistoricalInteractorsImp;
import com.example.fugle_realtime_java_sdk_core.intraday.IntradayInteractors;
import com.example.fugle_realtime_java_sdk_core.intraday.IntradayInteractorsImp;
import com.example.fugle_realtime_java_sdk_core.snapshot.SnapshotInteractors;
import com.example.fugle_realtime_java_sdk_core.snapshot.SnapshotInteractorsImp;
import com.example.fugle_realtime_java_sdk_core.tool.Constant;
import com.example.fugle_realtime_java_sdk_core.tool.HttpTool;
import com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool.HttpToolImp;
import com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool.ConstantImp;

@SpringBootApplication
public class FugleRealtimeJavaSdkExampleSpringbootResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(FugleRealtimeJavaSdkExampleSpringbootResttemplateApplication.class, args);
	}
	
	@Bean
	Constant constant() {
		return new ConstantImp();
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public HttpTool httpTool(RestTemplate restTemplate, Constant constant) {
		return new HttpToolImp(restTemplate, constant);
	}
	
	@Bean
	public IntradayInteractors intradayInteractors(HttpTool httpTool, Constant constant) {
		return new IntradayInteractorsImp(httpTool, constant);
	}
	
	@Bean
	public SnapshotInteractors snapshotInteractors(HttpTool httpTool, Constant constant) {
		return new SnapshotInteractorsImp(httpTool, constant);
	}
	
	@Bean
	public HistoricalInteractors historicalInteractors(HttpTool httpTool, Constant constant) {
		return new HistoricalInteractorsImp(httpTool, constant);
	}

}
