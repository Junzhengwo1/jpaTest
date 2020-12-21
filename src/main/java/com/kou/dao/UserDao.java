package com.kou.dao;

import com.kou.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author dell
 */
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

}
