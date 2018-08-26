package com.wbb.web.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wbb.bean.Cost;
import com.wbb.enums.EnumErrorCode;
import com.wbb.service.transaction.CostService;

@RestController
@RequestMapping("/test")
public class TestAction {

	@Resource
	private CostService costService;
	@RequestMapping(value="test1",method=RequestMethod.GET)
	public Object test1(){
		Cost cost = new Cost();
		cost.setMoney(100);
		costService.insert7(cost);
		return ResponseData.createResponseData(EnumErrorCode.OK, null);
	}

	@RequestMapping(value="test2",method=RequestMethod.GET)
	public Object test2() throws Exception{
		Cost cost = new Cost();
		cost.setMoney(100);
		costService.insert(cost,true);
		return ResponseData.createResponseData(EnumErrorCode.OK, costService.sum());
	}
}
