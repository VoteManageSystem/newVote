/**
 * 
 */
package com.vote.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vote.entity.User;
import com.vote.repository.JpaUserRepository;
import com.vote.service.ILoginService;

/**
 * @author zhanghonghao
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private JpaUserRepository jpaUserRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vote.service.ILoginService#login(com.vote.model.VUser)
	 */
	@Override
	@Transactional(readOnly = true)
	public boolean login(User vuser) {

		Map<String, String> parm = new HashMap<String, String>();
		parm.put("username", vuser.getUsername());
		parm.put("password", vuser.getPassword());
		User result = jpaUserRepository.findByUsername(vuser.getUsername());
		return false;
	}

}
