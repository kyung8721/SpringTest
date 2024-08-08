package com.kyung.spring.test.Store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.test.Store.domain.Store;
import com.kyung.spring.test.Store.service.StoreService;

@Controller
public class StoreContoller {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}
