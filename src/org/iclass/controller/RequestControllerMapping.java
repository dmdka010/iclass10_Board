package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.iclass.controller.community.ListController;
import org.iclass.controller.community.WriteController;
import org.iclass.controller.community.WriteViewController;

public class RequestControllerMapping {
	private static final Map<RequestKeyValue,Controller> mapping = new HashMap<>();
	
	public static void init() {
		//설계된 url,method 에 따라 처리할 controller 구현체를 Key,Value 로 HashMap에 저장합니다.
		mapping.put(new RequestKeyValue("/community/list", "GET"), new ListController() );
		mapping.put(new RequestKeyValue("/community/write","GET"), new WriteViewController() );
		mapping.put(new RequestKeyValue("/community/write","POST"), new WriteController() );
	}
	//url,method 필드를 저장하는 key 를 전달받아 HashMap에서 value(컨트롤러)를 리턴
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
}
