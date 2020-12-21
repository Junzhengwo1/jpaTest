package com.kou.dao;

import com.kou.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author JIAJUN KOu
 */

public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    /**
     * 根据名称查询结果
     * 使用jpql语句
     */
//    @Query(value = "from Customer where custName=?")
    public Customer findCustomerByCustName(String custName);

    /**
     * 根据客户名称和id查询客户
     * 使用jpql
     */
    @Query(value = "from Customer where custName=? and custId=?")
    public Customer findCustomerByCustNameAndCustId(String name,Long Id);

    /**
     * 根据id更新客户名称
     * 使用jpql
     */
    @Query(value = "update Customer set custName=?2 where custId=?1")
    @Modifying
    public void updateCustomer(Long id,String name);


    /**
     * 查询所有 使用sql语句
     */
    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Customer> findCustomerAll();

    /**
     * 根据用户名 模糊查询
     */
    @Query(value = "select * from cst_customer where cust_name like ?",nativeQuery = true)
    public List<Customer> findCustomerByName(String name);
}
