package com.lisz.mult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class DynamicDataSourceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/user")
    @DataSource(value = DataSourceType.USER)
    public List<Map<String, Object>> local(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        return maps;
    }
    @GetMapping("/arica")
    @DataSource(value = DataSourceType.ARICA)
    public List<Map<String, Object>> remote(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from item");
        return maps;
    }

}