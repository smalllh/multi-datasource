package com.wbb.schedule;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wbb.bean.Cost;
import com.wbb.service.transaction.CostService;

@Component
public class MySchedule {
	
	@Resource
	CostService costService;

	//@Scheduled(cron="0/10 * * * * *")
	public void insert() throws Exception {
		Cost cost = new Cost();
		cost.setMoney(50);
		costService.insert(cost, true);
	}
//	@Scheduled(cron="0/2 * * * * *")
//	public void insert2() throws Exception {
//		Cost cost = new Cost();
//		cost.setMoney(10);
//		costService.insert7(cost);
//	}
}
