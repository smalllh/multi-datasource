package com.wbb.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wbb.bean.Cost;
import com.wbb.bean.DataSourceDO;
import com.wbb.dataSource.dynamic.DataSourceBean;
import com.wbb.dataSource.dynamic.DataSourceBean.DataSourceBeanBuilder;
import com.wbb.dataSource.dynamic.DataSourceContext;
import com.wbb.mapper.DataSourceMapper;
import com.wbb.service.transaction.CostService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mvc.xml",
		"classpath:spring-dynamic-mybatis.xml" })
public class TestDynamicDataSource {

	@Resource
	CostService costService;
	@Resource
	DataSourceMapper dataSourceMapper;

	/**
	 * 动态切换数据源
	 */
	@Test
	public void testDynamicDataSource() {
		List<DataSourceDO> dataSourceDOList = dataSourceMapper.getAllDataSources();
		for (DataSourceDO dataSourceDO : dataSourceDOList) {
			DataSourceBean dataSourceBean = new DataSourceBean(new DataSourceBeanBuilder(dataSourceDO.getDatasourceName(),
					dataSourceDO.getDatabaseIp(), dataSourceDO.getDatabasePort(), dataSourceDO.getDatabaseName(),
					dataSourceDO.getUsername(), dataSourceDO.getPassword()));
			DataSourceContext.setDataSource(dataSourceBean);
			Cost cost = new Cost();
			cost.setMoney(100);
			try {
				costService.insert(cost, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			DataSourceContext.toDefault();
		}
	}
}
