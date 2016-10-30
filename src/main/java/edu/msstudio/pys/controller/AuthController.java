package edu.msstudio.pys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.msstudio.pys.model.User;
import edu.msstudio.pys.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userSrv;
	
	@ResponseBody
	@RequestMapping("/count")
	public Long counter() {
		return userSrv.count();
    }
}
