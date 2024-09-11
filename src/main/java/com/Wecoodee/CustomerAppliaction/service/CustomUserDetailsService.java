package com.Wecoodee.CustomerAppliaction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Wecoodee.CustomerAppliaction.model.User;
import com.Wecoodee.CustomerAppliaction.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

	public List<User> saveAllService(List<User> user) {

		System.out.println("save all service method is executing");

		return userRepository.saveAll(user);
//
//		List<User> list = new ArrayList<User>();
//
//		User s1 = new User(101, "Noor", "Noor@123", "nor@123");
//
//		list.add(s1);
//		
//		 Iterator itr=list.iterator();
//		 while(itr.hasNext()){  
//			 User st=(User)itr.next();  

//		userRepository.save(s1);

	}  
}
