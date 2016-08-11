package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.app.User;

import com.course.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void delete(String username) throws Exception {
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new Exception("User with " + username + "Not found");
		} else {
			userRepository.delete(username);
		}
	}

	public User save(User user) throws Exception {
		return userRepository.save(user);
	}

	public User findUserByName(String username) throws Exception {
		return userRepository.findOne(username);
	}
}