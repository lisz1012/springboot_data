package com.lisz.controller;

import com.lisz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/selectAll")
	public List<Map<String, Object>> selectAll(){
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
		return maps;
	}

	@PostMapping("/add")
	public String addUser(){
		String sql = "insert into user (name, job, email, version) values ('aaa', 'bbb', 'aaa@gmail.com', 1)";
		int update = jdbcTemplate.update(sql);
		System.out.println(update);
		return "add_success";
	}

	@PostMapping("/updateUser/{id}")
	public String updateUser(@PathVariable int id){
		String sql = "update user set name=? where id = ?";
		String name = "cassiel2";
		System.out.println(jdbcTemplate.update(sql, name, id));
		return "update_success";
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id){
		String sql = "delete from user where id = ?";
		int update = jdbcTemplate.update(sql, id);
		System.out.println(update);
		return "delete_success";
	}
}
