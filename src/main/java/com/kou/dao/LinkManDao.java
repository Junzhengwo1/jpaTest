package com.kou.dao;

import com.kou.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author JIAJUN KOU
 */
public interface LinkManDao extends JpaRepository<LinkMan, Long>, JpaSpecificationExecutor<LinkMan> {
}
