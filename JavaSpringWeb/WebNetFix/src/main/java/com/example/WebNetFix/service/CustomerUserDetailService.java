package com.example.WebNetFix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.WebNetFix.mapper.UserMapper;
import com.example.WebNetFix.model.User;
import com.example.WebNetFix.model.UserExample;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		
		UserExample example= new UserExample();
		example.createCriteria().andEmailEqualTo(username);
		
		List<User> listUser = userMapper.selectByExample(example);
		
		if(listUser.size()>0) {
			User user=listUser.get(0);
			
			List<GrantedAuthority> gramlist= new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
			gramlist.add(authority);
			
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),gramlist);
		
			return userDetails;
		}else {
			new UsernameNotFoundException("Login Fail!");
		}
		
		
		return null;
	}

}
