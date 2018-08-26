package com.wbb.service.transaction.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wbb.bean.Cost;
import com.wbb.mapper.CostMapper;
import com.wbb.service.transaction.CostService;
import com.wbb.service.transaction.CostService2;

@Service
public class CostServiceImpl2 implements CostService2{
	
	@Resource
	private CostMapper costMapper;
	@Resource
	private CostService costService;
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void insert(Cost cost,boolean b) throws Exception {
		System.out.println("insert:"+costMapper.insert(cost));
		try {
			costService.insert3(cost, b);//propagation=Propagation.REQUIRES_NEW
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void insert2(Cost cost,boolean b) throws Exception {
		System.out.println("insert:"+costMapper.insert(cost));
		try {
			costService.insert(cost, b);//propagation=Propagation.REQUIRED
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void insert3(Cost cost,boolean b) throws Exception {
		System.out.println("insert:"+costMapper.insert(cost));
		costService.insert3(cost, b);
	}
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void insert4(Cost cost, boolean b) throws Exception {
		System.out.println("insert:"+costMapper.insert(cost));
		costService.insert(cost, b);	
	}
}