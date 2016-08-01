/**
 * 
 */
package com.vote.repository;

import com.vote.entity.User;

/**
 * @author zhanghonghao
 *
 */
public interface UserRepository {

	User findByUsername(String username);
}