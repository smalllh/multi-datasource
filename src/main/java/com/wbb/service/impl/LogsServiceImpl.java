package com.wbb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wbb.bean.Logs;
import com.wbb.mapper.LogsMapper;
import com.wbb.service.LogsService;

@Service
public class LogsServiceImpl implements LogsService{

	@Resource
	private LogsMapper logsMapper;
	@Override
	public int addLogs(Logs logs) {	
		return logsMapper.insertSelective(logs);
	}

}
