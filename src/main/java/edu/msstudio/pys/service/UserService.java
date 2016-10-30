package edu.msstudio.pys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.msstudio.pys.Exception.UserException;
import edu.msstudio.pys.model.User;
import edu.msstudio.pys.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userDao;

	public Iterable<User> getUser(){
		return userDao.findAll();
	}
	
	public Iterable<User> getUserById(Long id){
		return userDao.findAll();
	}
	
	public long count(){
		return userDao.count();
	}
}
