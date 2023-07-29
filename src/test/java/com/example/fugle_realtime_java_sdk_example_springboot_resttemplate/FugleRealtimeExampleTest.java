package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FugleRealtimeExampleTest {
	
	@Autowired
	FugleRealtimeExample fugleRealtimeSample;
	
	@Test
	void tickers() {
		fugleRealtimeSample.tickers();
	}
	
	@Test
	void ticker() {
		fugleRealtimeSample.ticker();
	}
	
	@Test
	void quote() {
		fugleRealtimeSample.quote();
	}
	
	@Test
	void candles() {
		fugleRealtimeSample.candles();
	}
	
	@Test
	void trades() {
		fugleRealtimeSample.trades();
	}
	
	@Test
	void volumes() {
		fugleRealtimeSample.volumes();
	}
	
	@Test
	@Disabled
	void quotes() {
		fugleRealtimeSample.quotes();
	}
	
	@Test
	@Disabled
	void movers() {
		fugleRealtimeSample.movers();
	}
	
	@Test
	@Disabled
	void actives() {
		fugleRealtimeSample.actives();
	}
	
	@Test
	void historicalCandles() {
		fugleRealtimeSample.historicalCandles();
	}
	
	@Test
	void stats() {
		fugleRealtimeSample.stats();
	}
	

}
