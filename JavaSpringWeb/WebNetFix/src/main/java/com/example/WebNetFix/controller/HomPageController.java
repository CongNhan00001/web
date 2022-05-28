package com.example.WebNetFix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.WebNetFix.mapper.UserMapper;

@Controller
public class HomPageController {
	
	@Autowired
	UserMapper userMapper;
	
	
	@RequestMapping("/login")
	public ModelAndView indx() {
		ModelAndView modelAndView = new ModelAndView("index");
		
		/*
		 * UserExample example= new UserExample();
		 * 
		 * example.createCriteria().andIdEqualTo((long)1).andUserNameEqualTo("NHAN");
		 * 
		 * List<User>listuser= userMapper.selectByExample(example);
		 * 
		 * 
		 * for(User value:listuser) {
		 * System.out.println("kiem tra "+value.getFullName()); }
		 */
		
		Map<String,Object> param= new HashMap<>();
		param.put("userName", "NHAN");
		param.put("id", 1);
		List<Map<String,Object>> listUser= userMapper.getAllUser(param);
		
		for(Map<String,Object> value:listUser) {
			  System.out.println("kiem tra "+value.get("full_name")); }
		
		
		return modelAndView;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("home");
		
		return modelAndView;
	}
}
