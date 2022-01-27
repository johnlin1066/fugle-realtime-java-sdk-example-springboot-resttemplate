package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fugle_realtime_java_sdk_core.FugleRealtime;
import com.example.fugle_realtime_java_sdk_core.dto.request.RequestObject;
import com.example.fugle_realtime_java_sdk_core.dto.request.RequestObjectBuilder;
import com.example.fugle_realtime_java_sdk_core.dto.response.ResponseObject;
import com.example.fugle_realtime_java_sdk_core.dto.response.dealts.Dealts;
import com.example.fugle_realtime_java_sdk_core.dto.response.volumes.Volumes;

@Component
public class FugleRealtimeExample {
	
	@Autowired
	FugleRealtime fugleRealtime;
	
	String SymbolId = "2884";
	String ApiToken = "demo";
	
	public void chart() {
		RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
		ResponseObject responseObject = fugleRealtime.chart(requestObject);
		
		System.out.println("=====Chart=====");
		System.out.println("此分鐘的開盤價 = " + responseObject.getData().getChart().getO().get(0));
		System.out.println("此分鐘的最高價 = " + responseObject.getData().getChart().getH().get(0));
		System.out.println("此分鐘的最低價 = " + responseObject.getData().getChart().getL().get(0));
		System.out.println("此分鐘的收盤價 = " + responseObject.getData().getChart().getC().get(0));
	}
	
	public void quote() {
		RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
		ResponseObject responseObject = fugleRealtime.quote(requestObject);
		
		System.out.println("=====Quote=====");
		System.out.println("當日之最高價 = " + responseObject.getData().getQuote().getPriceHigh().getPrice());
		System.out.println("當日之最低價 = " + responseObject.getData().getQuote().getPriceLow().getPrice());
		System.out.println("最新一筆成交價 = " + responseObject.getData().getQuote().getTrade().getPrice());
		System.out.println("當日股價之漲跌 = " + responseObject.getData().getQuote().getChange());
		System.out.println("當日股價之漲跌幅 = " + responseObject.getData().getQuote().getChangePercent());
		System.out.println("最新一筆最佳五檔-買最高價 = " + responseObject.getData().getQuote().getOrder().getBids().get(0).getPrice());
		System.out.println("最新一筆最佳五檔-賣最低價 = " + responseObject.getData().getQuote().getOrder().getAsks().get(0).getPrice());
		
	}
	
	public void meta() {
		RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
		ResponseObject responseObject = fugleRealtime.meta(requestObject);
		
		System.out.println("=====Meta=====");
		System.out.println("漲停價 = " + responseObject.getData().getMeta().getPriceHighLimit());
		System.out.println("跌停價 = " + responseObject.getData().getMeta().getPriceLowLimit());
		
	}
	
	public void dealts() {
		RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
		ResponseObject responseObject = fugleRealtime.dealts(requestObject);
		
		System.out.println("=====Dealts=====");
		System.out.println("成交彙整");
		for(Dealts dealts : responseObject.getData().getDealts())
			System.out.println("時間 = " + dealts.getAt() + ", 成交價 = " + dealts.getPrice() + ", 成交量 = " + dealts.getVolume());
	}
	
	public void volumes() {
		RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
		ResponseObject responseObject = fugleRealtime.volumes(requestObject);
		
		System.out.println("=====Volumes=====");
		System.out.println("價量變化");
		for(Volumes volumes : responseObject.getData().getVolumes())
			System.out.println("成交價 = " + volumes.getPrice() + ", 	成交量 = " + volumes.getVolume());
	}
	

}
