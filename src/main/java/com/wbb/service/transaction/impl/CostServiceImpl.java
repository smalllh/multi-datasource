package com.wbb.service.transaction.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wbb.bean.Cost;
import com.wbb.mapper.CostMapper;
import com.wbb.service.transaction.CostService;

@Service
public class CostServiceImpl implements CostService {

	@Resource
	private CostMapper costMapper;

	/**
	 * Spring定义了7个以PROPAGATION_开头的常量表示它的传播属性。
	 * PROPAGATION_REQUIRED 支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择，也是Spring默认的事务的传播。
	 * PROPAGATION_SUPPORTS 支持当前事务，如果当前没有事务，就以非事务方式执行。
	 * PROPAGATION_MANDATORY 支持当前事务，如果当前没有事务，就抛出异常。 
	 * PROPAGATION_REQUIRES_NEW 新建事务，如果当前存在事务，把当前事务挂起。
	 * PROPAGATION_NOT_SUPPORTED 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
	 * PROPAGATION_NEVER以非事务方式执行，如果当前存在事务，则抛出异常。
	 * PROPAGATION_NESTED如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，
	 * 则进行与PROPAGATION_REQUIRED类似的操作。
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insert(Cost cost, boolean b) throws Exception {
		System.out.println("insert:" + costMapper.insert(cost));
		if (!b) {
			throw new Exception("自定义错误");
		}
	}

	@Override
	public int sum() {
		return costMapper.sum();
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void insert2(Cost cost, boolean b) throws Exception {
		System.out.println("insert2:" + costMapper.insert(cost));
		try {
			insert(cost, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void insert5(Cost cost, boolean b) throws Exception {
		System.out.println("insert5:" + costMapper.insert(cost));
		insert(cost, b);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void insert3(Cost cost, boolean b) throws Exception {
		System.out.println("insert3:" + costMapper.insert(cost));
		if (!b) {
			throw new Exception("自定义错误");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void insert4(Cost cost, boolean b) throws Exception {
		System.out.println("insert4:" + costMapper.insert(cost));
		try {
			insert3(cost, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void insert6(Cost cost, boolean b) throws Exception {
		System.out.println("insert4:" + costMapper.insert(cost));
		insert3(cost, b);
	}

	@Transactional(rollbackFor = Exception.class)
	public void insert7(Cost c) {
		costMapper.insert(c);
		int a = 1 / 0;
	}

	@Override
	public int insert8(Cost cost) {
		System.out.println("insert8");
		return costMapper.insert(cost);
	}
}