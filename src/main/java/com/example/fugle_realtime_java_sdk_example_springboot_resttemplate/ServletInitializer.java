package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FugleRealtimeJavaSdkExampleSpringbootResttemplateApplication.class);
	}

}
