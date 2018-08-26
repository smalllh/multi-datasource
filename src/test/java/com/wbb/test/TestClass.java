package com.wbb.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wbb.bean.Cost;
import com.wbb.service.transaction.CostService;
import com.wbb.service.transaction.CostService2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring.xml",
		"classpath:spring-mvc.xml",
		"classpath:spring-mybatis.xml",
		})
public class TestClass {

	@Resource
	CostService costService;
	@Resource
	CostService2 costService2;
	@Test
	public void test1(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 同一个service,里外都是Propagation.REQUIRED,里层被trycatch，里层抛异常,里外都提交
	 */
	@Test
	public void test2(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert2(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert2(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 同一个service,里外都是Propagation.REQUIRED,里层不被trycatch，里层抛异常,里外都不提交
	 */
	@Test
	public void test3(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert5(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert5(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 同一个service，外Propagation.REQUIRED里Propagation.REQUIRES_NEW，里层被trycatch，里层抛异常,里外都提交
	 */
	@Test
	public void test4(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert4(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert4(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 	
	 * 同一个service，外Propagation.REQUIRED里Propagation.REQUIRES_NEW，里层不被trycatch，里层抛异常,里外都不提交
	 */
	@Test
	public void test5(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert6(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert6(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 两个service,，外Propagation.REQUIRED里Propagation.REQUIRES_NEW,里层被trycatch，里层抛异常,里不提交,外提交
	 */
	@Test
	public void test6(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService2.insert(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService2.insert(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 两个service,，外Propagation.REQUIRED里Propagation.REQUIRES_NEW,里层不被trycatch，里层抛异常,里外都不提交
	 */
	@Test
	public void test8(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService2.insert3(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService2.insert3(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 两个service,，里外Propagation.REQUIRED,里层被trycatch，里层抛异常,里外都不提交
	 */
	@Test
	public void test7(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService2.insert2(cost, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService2.insert2(cost, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	/**
	 * 	/**
	 * 两个service,，里外Propagation.REQUIRED,里层不被trycatch，里层抛异常,里外都不提交
	 */
	@Test
	public void test9(){
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert7(cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
		System.out.println("--------------------------");
		System.out.println("before insert:"+costService.sum());
		try {
			Cost cost = new Cost();
			cost.setMoney(100);
			costService.insert7(cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after insert:"+costService.sum());
	}
	@Test
	public void testAop() {
		Cost cost = new Cost();
		cost.setMoney(100);
		costService.insert8(cost);
	}
}