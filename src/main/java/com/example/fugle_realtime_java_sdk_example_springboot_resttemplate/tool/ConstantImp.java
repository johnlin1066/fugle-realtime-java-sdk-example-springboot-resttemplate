package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.fugle_realtime_java_sdk_core.tool.Constant;


@Component
@ConfigurationProperties(prefix="self-constant")
public class ConstantImp extends Constant{
	
}
