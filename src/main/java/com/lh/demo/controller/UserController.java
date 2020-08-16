package com.lh.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.lh.demo.config.DynamicDataSourceContextHolder;
import com.lh.demo.config.DynamicRoutingDataSource;
import com.lh.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lh.demo.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @Resource
    private DynamicRoutingDataSource dynamicDataSource;

    /**
     * 添加数据源示例
     *
     * @return
     */
    @RequestMapping("/add_data_source")
    @ResponseBody
    public Map<String, Object> addDataSource() {
        // 构建 DataSource 属性,
        Map<String, String> map = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        map.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, "com.mysql.jdbc.Driver");
        map.put(DruidDataSourceFactory.PROP_URL, "jdbc:mysql://47.98.182.173:3306/lhtest?useSSL=false");
        map.put(DruidDataSourceFactory.PROP_USERNAME,
                "root");
        map.put(DruidDataSourceFactory.PROP_PASSWORD,
                "1111");
        map.put("database", "dynamic_db2");
        if (dynamicDataSource.addDataSource(map)) {
            resultMap.put("msg", "添加成功");
            resultMap.put("datasource", map);
            return resultMap;
        }
        resultMap.put("msg", "添加失败");
        return resultMap;
    }

    /**
     * 切换数据源示例
     *
     * @return
     */
    @RequestMapping("/get")
    public Object get() {
        // 设置数据源
        DynamicDataSourceContextHolder.setDataSourceKey("dynamic_db2");
        Map<String, Object> map = new HashMap<>();
        User u = userService.get();
        map.put("u0", u);
        return map;
    }

    @RequestMapping("/get/default")
    public Object getDefault() {
        // 用默认数据源
        DynamicDataSourceContextHolder.setDataSourceKey("datasource");
        Map<String, Object> map = new HashMap<>();
        User u = userService.get();
        map.put("u0", u);
        return map;
    }

}
