package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FugleRealtimeExampleTest {
	
	@Autowired
	FugleRealtimeExample fugleRealtimeSample;
	
	@Test
	void chart() {
		fugleRealtimeSample.chart();
	}
	
	@Test
	void quote() {
		fugleRealtimeSample.quote();
	}
	
	@Test
	void meta() {
		fugleRealtimeSample.meta();
	}
	
	@Test
	void dealts() {
		fugleRealtimeSample.dealts();
	}
	
	@Test
	void volumes() {
		fugleRealtimeSample.volumes();
	}

}
