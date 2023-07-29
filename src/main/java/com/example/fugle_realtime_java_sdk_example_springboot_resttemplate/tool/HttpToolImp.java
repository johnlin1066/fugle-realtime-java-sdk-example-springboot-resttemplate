package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate.tool;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

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
import com.example.fugle_realtime_java_sdk_core.tool.Constant;
import com.example.fugle_realtime_java_sdk_core.tool.HttpTool;

public class HttpToolImp implements HttpTool{
	
	RestTemplate restTemplate;
	Constant constant;
	
	public HttpToolImp(RestTemplate restTemplate, Constant constant) {
		this.restTemplate = restTemplate;
		this.constant = constant;
	}

	@Override
	public TickersResponse getForTickersResponse(String url) {
		ResponseEntity<TickersResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				TickersResponse.class);
		return response.getBody();
	}
	HttpEntity<Object> addHeader(){
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("X-API-KEY", constant.getxApiKey());
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		return requestEntity;
	}
	
	@Override
	public TickerResponse getForTickerResponse(String url) {
		ResponseEntity<TickerResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				TickerResponse.class);
		return response.getBody();
	}

	@Override
	public QuoteResponse getForQuoteResponse(String url) {
		ResponseEntity<QuoteResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				QuoteResponse.class);
		return response.getBody();
	}

	@Override
	public CandlesResponse getForCandlesResponse(String url) {
		ResponseEntity<CandlesResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				CandlesResponse.class);
		return response.getBody();
	}

	@Override
	public TradesResponse getForTradesResponse(String url) {
		ResponseEntity<TradesResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				TradesResponse.class);
		return response.getBody();
	}

	@Override
	public VolumesResponse getForVolumesResponse(String url) {
		ResponseEntity<VolumesResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				VolumesResponse.class);
		return response.getBody();
	}

	@Override
	public QuotesResponse getForQuotesResponse(String url) {
		ResponseEntity<QuotesResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				QuotesResponse.class);
		return response.getBody();
	}

	@Override
	public MoversResponse getForMoversResponse(String url) {
		ResponseEntity<MoversResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				MoversResponse.class);
		return response.getBody();
	}

	@Override
	public ActivesResponse getForActivesResponse(String url) {
		ResponseEntity<ActivesResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				ActivesResponse.class);
		return response.getBody();
	}

	@Override
	public HistoricalCandlesResponse getForHistoricalCandlesResponse(String url) {
		ResponseEntity<HistoricalCandlesResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				HistoricalCandlesResponse.class);
		return response.getBody();
	}

	@Override
	public StatsResponse getForStatsResponse(String url) {
		ResponseEntity<StatsResponse> response = restTemplate.exchange(url, HttpMethod.GET, addHeader(),
				StatsResponse.class);
		return response.getBody();
	}

}
