# Fugle Realtime Java SDK Example

Fugle Realtime Java SDK Example 使用 SpringBoot 提供的 RestTemplate 來實作 [fugle-realtime-java-sdk-core](https://github.com/johnlin1066/fugle-realtime-java-sdk-core) 的HttpTool。

## Usage
RUN JUnit Test - FugleRealtimeExampleTest.java

## How to use fugle-realtime-java-sdk-core in SpringBoot
### Install
Clone [fugle-realtime-java-sdk-core](https://github.com/johnlin1066/fugle-realtime-java-sdk-core)
```
cd fugle-realtime-java-sdk-core
mvn install
```

### Import in your SpringBoot Project
```
<dependency>
	<groupId>com.example</groupId>
	<artifactId>fugle-realtime-java-sdk-core</artifactId>
	<version>0.0.1</version>
</dependency>
```

### Implement HttpTool (責任為發出GET請求與包裝回傳對象成ResponseObject)
```
public class HttpToolImp implements HttpTool{
	
	RestTemplate restTemplate;
	
	public HttpToolImp(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public ResponseObject getForObject(String url) {
		return restTemplate.getForObject(url, ResponseObject.class);
	}

}
```

### New Instance
```
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
```

### Usage
```
@Autowired
FugleRealtime fugleRealtime;

...

RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
ResponseObject responseObject = fugleRealtime.chart(requestObject);

RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
ResponseObject responseObject = fugleRealtime.quote(requestObject);

RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
ResponseObject responseObject = fugleRealtime.meta(requestObject);

RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
ResponseObject responseObject = fugleRealtime.dealts(requestObject);

RequestObject requestObject = new RequestObjectBuilder().setSymbolId(SymbolId).setApiToken(ApiToken).build();
ResponseObject responseObject = fugleRealtime.volumes(requestObject);	
```
