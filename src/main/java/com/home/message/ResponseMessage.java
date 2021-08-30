package com.home.message;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage<T>{
	private T data;
	private Map<String, String> links = new HashMap<String, String>();
	public ResponseMessage(T tmp){
		 this.data = tmp;
	}
	public void addLinks(String key, String url) {
		links.put(key, url);
	}
	public T getData() {
		return data;
	}
	public Map<String, String> getLinks() {
		return links;
	}
}
