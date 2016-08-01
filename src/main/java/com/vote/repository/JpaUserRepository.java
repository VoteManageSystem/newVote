/**
 * 
 */
package com.vote.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.vote.entity.User;

/**
 * @author zhanghonghao
 *
 */
@Repository
public class JpaUserRepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findByUsername(String username) {
		return this.entityManager.createQuery("SELECT n FROM User n", User.class).getSingleResult();
	}

}
