package com.kou.dao;

import com.kou.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author JIAJUN KOU
 */
public interface RoleDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
