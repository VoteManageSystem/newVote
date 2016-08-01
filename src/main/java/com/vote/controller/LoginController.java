/**
 * 
 */
package com.vote.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vote.entity.User;
import com.vote.service.ILoginService;

//import com.vote.entity.User;
//import com.vote.service.ILoginService;

/**
 * @author zhanghonghao
 *
 */
@Controller
@RequestMapping("logins")
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "login_in")
	@ResponseBody
	public Map<String, Object> login_in(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		User vuser = new User();
		vuser.setUsername(request.getParameter("username"));
		vuser.setPassword(request.getParameter("password"));
		loginService.login(vuser);

		returnMap.put("returnCode", vuser.getPassword());
		returnMap.put("returnMsg", vuser.getUsername());
		return returnMap;
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
