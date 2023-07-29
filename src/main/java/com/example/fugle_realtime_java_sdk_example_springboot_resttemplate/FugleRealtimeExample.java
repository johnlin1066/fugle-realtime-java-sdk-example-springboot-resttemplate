package com.example.fugle_realtime_java_sdk_example_springboot_resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fugle_realtime_java_sdk_core.historical.HistoricalInteractors;
import com.example.fugle_realtime_java_sdk_core.historical.request.HistoricalRequest;
import com.example.fugle_realtime_java_sdk_core.historical.request.HistoricalRequestBuilder;
import com.example.fugle_realtime_java_sdk_core.historical.response.Candle;
import com.example.fugle_realtime_java_sdk_core.historical.response.HistoricalCandlesResponse;
import com.example.fugle_realtime_java_sdk_core.historical.response.StatsResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.IntradayInteractors;
import com.example.fugle_realtime_java_sdk_core.intraday.request.IntradayRequest;
import com.example.fugle_realtime_java_sdk_core.intraday.request.IntradayRequestBuilder;
import com.example.fugle_realtime_java_sdk_core.intraday.response.CandlesResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.Data;
import com.example.fugle_realtime_java_sdk_core.intraday.response.QuoteResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.TickerResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.TickersResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.TradesResponse;
import com.example.fugle_realtime_java_sdk_core.intraday.response.VolumesResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.SnapshotInteractors;
import com.example.fugle_realtime_java_sdk_core.snapshot.request.SnapshotRequest;
import com.example.fugle_realtime_java_sdk_core.snapshot.request.SnapshotRequestBuilder;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.ActivesResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.MoversResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.QuotesResponse;
import com.example.fugle_realtime_java_sdk_core.snapshot.response.Snapshot;

@Component
public class FugleRealtimeExample {
	
	@Autowired
	IntradayInteractors intradayInteractors;
	@Autowired
	SnapshotInteractors snapshotInteractors;
	@Autowired
	HistoricalInteractors historicalInteractors;
	
	void tickers() {
		IntradayRequest intradayRequest = new IntradayRequestBuilder().setType("EQUITY")
				.setExchange("TWSE").setMarket("TSE").setIndustry("24").setNormal(true).build();
		TickersResponse tickersResponse = intradayInteractors.tickers(intradayRequest);
		
		System.out.println("=====Tickers=====");
		for(Data data : tickersResponse.getData())
			System.out.println("股票代碼 " + data.getSymbol() + ", 股票簡稱 " + data.getName());
	}
	
	void ticker() {
		IntradayRequest intradayRequest = new IntradayRequestBuilder().setSymbol("2330").build();
		TickerResponse tickerResponse = intradayInteractors.ticker(intradayRequest);
		
		System.out.println("=====Ticker=====");
		System.out.println("股票代碼 " + tickerResponse.getSymbol() + ", 股票簡稱 " + tickerResponse.getName() 
		+ ", 參考價 " + tickerResponse.getReferencePrice());
	}
	
	void quote() {
		IntradayRequest intradayRequest = new IntradayRequestBuilder().setSymbol("2330").build();
		QuoteResponse quoteResponse = intradayInteractors.quote(intradayRequest);
		
		System.out.println("=====Quote=====");
		System.out.println("最佳五檔委買價格  最佳五檔委賣");
		for(int i=0; i<5; i++)
			System.out.println(quoteResponse.getBids().get(i).getPrice() + " " + quoteResponse.getBids().get(i).getSize() 
					+ "  " + quoteResponse.getAsks().get(i).getPrice() + " " + quoteResponse.getBids().get(i).getSize());
		System.out.println("最後一筆成交資訊");
		System.out.println("最後一筆成交買價 " + quoteResponse.getLastTrade().getBid() 
				+ ", 最後一筆成交賣價" +quoteResponse.getLastTrade().getAsk()
				+ ", 最後一筆成交價格" +quoteResponse.getLastTrade().getPrice()
				+ ", 最後一筆成交數量" +quoteResponse.getLastTrade().getSize());
	}
	
	void candles() {
		IntradayRequest intradayRequest = new IntradayRequestBuilder().setSymbol("2330").setTimeframe("60").build();
		CandlesResponse candlesResponse = intradayInteractors.candles(intradayRequest);
		
		System.out.println("=====Candles=====");
		System.out.println("Ｋ線資料");
		for(Data data : candlesResponse.getData())
			System.out.println("Ｋ線開盤價 "+data.getOpen() + ", Ｋ線最高價 "+data.getHigh() + ", Ｋ線最低價 "+data.getLow()
			+ ", Ｋ線收盤價 "+data.getClose() + ", Ｋ線成交量 "+data.getVolume() + ", 成交均價 "+data.getAverage());
	}
	
	void trades() {
		IntradayRequest intradayRequest = new IntradayRequestBuilder().setSymbol("2330").build();
		TradesResponse tradesResponse = intradayInteractors.trades(intradayRequest);
		
		System.out.println("=====Trades=====");
		System.out.println("成交明細");
		for(Data data : tradesResponse.getData())
			System.out.println("成交買價 "+data.getBid() + ", 成交賣價 "+data.getAsk() + ", 成交價格 "+data.getPrice()
			+ ", 成交單量 "+data.getSize() + ", 成交總量 "+data.getVolume() + ", 成交時間 "+data.getTime());
	}
	
	void volumes() {
		IntradayRequest intradayRequest = new IntradayRequestBuilder().setSymbol("2330").build();
		VolumesResponse volumesResponse = intradayInteractors.volumes(intradayRequest);
		
		System.out.println("=====Volumes=====");
		System.out.println("分價量表");
		for(Data data : volumesResponse.getData())
			System.out.println("成交價 "+data.getPrice() + ", 該成交價之累計成交量 "+data.getVolume());
	}
	
	void quotes() {
		SnapshotRequest snapshotRequest = new SnapshotRequestBuilder().setMarket("TSE").build();
		QuotesResponse quotesResponse = snapshotInteractors.quotes(snapshotRequest);
		
		System.out.println("=====Quotes=====");
		System.out.println("股票行情快照");
		for(Snapshot data : quotesResponse.getData())
			System.out.println("股票代碼 "+data.getSymbol() + ", 股票簡稱 "+data.getName() + ", 開盤價 "+data.getOpenPrice()
			+ ", 最高價 "+data.getHighPrice() + ", 最低價 "+data.getLowPrice() + ", 收盤價 "+data.getClosePrice() 
			+ ", 漲跌 "+data.getChange() + ", 漲跌幅 "+data.getChangePercent() + ", 成交量 "+data.getTradeVolume() 
			+ ", 成交金額 "+data.getTradeValue() + ", 快照時間 "+data.getLastUpdated());
	}
	
	void movers() {
		SnapshotRequest snapshotRequest = new SnapshotRequestBuilder().setMarket("TSE").setDirection("up")
				.setChange("percent").build();
		MoversResponse moversResponse = snapshotInteractors.movers(snapshotRequest);
		
		System.out.println("=====Movers=====");
		System.out.println("股票漲跌幅排行");
		for(Snapshot data : moversResponse.getData())
			System.out.println("股票代碼 "+data.getSymbol() + ", 股票簡稱 "+data.getName() + ", 開盤價 "+data.getOpenPrice()
			+ ", 最高價 "+data.getHighPrice() + ", 最低價 "+data.getLowPrice() + ", 收盤價 "+data.getClosePrice() 
			+ ", 漲跌 "+data.getChange() + ", 漲跌幅 "+data.getChangePercent() + ", 成交量 "+data.getTradeVolume() 
			+ ", 成交金額 "+data.getTradeValue() + ", 快照時間 "+data.getLastUpdated());
		
	}
	
	void actives() {
		SnapshotRequest snapshotRequest = new SnapshotRequestBuilder().setMarket("TSE").setTrade("value").build();
		ActivesResponse activesResponse = snapshotInteractors.actives(snapshotRequest);
		
		System.out.println("=====Actives=====");
		System.out.println("股票成交量值排行");
		for(Snapshot data : activesResponse.getData())
			System.out.println("股票代碼 "+data.getSymbol() + ", 股票簡稱 "+data.getName() + ", 開盤價 "+data.getOpenPrice()
			+ ", 最高價 "+data.getHighPrice() + ", 最低價 "+data.getLowPrice() + ", 收盤價 "+data.getClosePrice() 
			+ ", 漲跌 "+data.getChange() + ", 漲跌幅 "+data.getChangePercent() + ", 成交量 "+data.getTradeVolume() 
			+ ", 成交金額 "+data.getTradeValue() + ", 快照時間 "+data.getLastUpdated());
		
	}
	
	void historicalCandles() {
		HistoricalRequest historicalRequest = new HistoricalRequestBuilder().setSymbol("2330")
				.setFields("open,high,low,close,volume").build();
		HistoricalCandlesResponse historicalCandlesResponse = historicalInteractors.historicalCandles(historicalRequest);
		
		System.out.println("=====Historical Candles=====");
		System.out.println("取得1年內歷史股價");
		for(Candle data : historicalCandlesResponse.getData())
			System.out.println("日期 "+data.getDate() + ", 開盤價 "+data.getOpen() + ", 最高價 "+data.getHigh()
			+ ", 最低價 "+data.getLow() + ", 收盤價 "+data.getClose() + ", 成交量 "+data.getVolume() 
			+ ", 漲跌 "+data.getChange());
		
	}
	
	void stats() {
		HistoricalRequest historicalRequest = new HistoricalRequestBuilder().setSymbol("2330").build();
		StatsResponse statsResponse = historicalInteractors.stats(historicalRequest);
		
		System.out.println("=====Stats=====");
		System.out.println("取得近52週股價數據");
		System.out.println("股票代碼 "+statsResponse.getSymbol() + ", 股票簡稱 "+statsResponse.getName() 
		+ ", 最後交易日開盤價 "+statsResponse.getOpenPrice()+ ", 最後交易日最高價 "+statsResponse.getHighPrice() 
		+ ", 最後交易日最低價 "+statsResponse.getLowPrice() + ", 最後交易日收盤價 "+statsResponse.getClosePrice() 
		+ ", 近52週高點 "+statsResponse.getWeek52High() + ", 近52週低點 "+statsResponse.getWeek52Low());
	}

	
}
