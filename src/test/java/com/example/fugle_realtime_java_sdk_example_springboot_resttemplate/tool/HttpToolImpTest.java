package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fugle_realtime_java_sdk_core.historical.response.HistoricalCandlesResponse;
import com.example.fugle_realtime_java_sdk_core.historical.response.StatsResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.CandlesResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.QuoteResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.TickerResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.TickersResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.TradesResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.VolumesResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.ActivesResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.MoversResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.QuotesResponse;
import com.example.fugle_realtime_java_sdk_core.tool.HttpTool;

@SpringBootTest
public class HttpToolImpTest {
	
	@Autowired
	HttpTool httpTool;
	
	@Test
	@Disabled("test")
	public void getForTickersResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/intraday/tickers?type=EQUITY&exchange=TWSE"
				+ "&market=TSE&industry=01&isNormal=true";
		
		TickersResponse responseObject = httpTool.getForTickersResponse(url);
		
		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForTickerResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/intraday/ticker/2330";
		
		TickerResponse responseObject = httpTool.getForTickerResponse(url);
		
		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForQuoteResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/intraday/quote/2330";
		
		QuoteResponse responseObject = httpTool.getForQuoteResponse(url);
		
		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForCandlesResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/intraday/candles/2330";
		
		CandlesResponse responseObject = httpTool.getForCandlesResponse(url);
		
		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForTradesResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/intraday/trades/0050";
		
		TradesResponse responseObject = httpTool.getForTradesResponse(url);
		
		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForVolumesResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/intraday/volumes/2330";
		
		VolumesResponse responseObject = httpTool.getForVolumesResponse(url);
		
		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForQuotesResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/snapshot/quotes/TSE";
		
		QuotesResponse responseObject = httpTool.getForQuotesResponse(url);

		assertEquals(true, null!=responseObject);
	}

	@Test
	@Disabled("test")
	public void getForMoversResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/snapshot/movers/TSE?direction=up&change=percent";
		
		MoversResponse responseObject = httpTool.getForMoversResponse(url);

		assertEquals(true, null!=responseObject);
	}

	@Test
	@Disabled("test")
	public void getForActivesResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/snapshot/actives/TSE?trade=value";
		
		ActivesResponse responseObject = httpTool.getForActivesResponse(url);

		assertEquals(true, null!=responseObject);
	}
	
	@Test
	@Disabled("test")
	public void getForHistoricalCandlesResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/historical/candles/0050?fields=open,high,low,close,volume";
		
		HistoricalCandlesResponse responseObject = httpTool.getForHistoricalCandlesResponse(url);

		assertEquals(true, null!=responseObject);
	}

	@Test
	@Disabled("test")
	public void getForStatsResponse() {
		String url = "https://api.fugle.tw/marketdata/v1.0/stock/historical/stats/0050";
		
		StatsResponse responseObject = httpTool.getForStatsResponse(url);

		assertEquals(true, null!=responseObject);
	}
}
