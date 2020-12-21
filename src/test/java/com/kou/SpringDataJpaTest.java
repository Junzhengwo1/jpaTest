package com.kou;

import com.kou.dao.CustomerDao;
import com.kou.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JIAJUN KOU
 * SpringDataJpa测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJpaTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 通过id查询出一个
     */
    @Test
    public void FindOne(){
        Customer one = customerDao.findOne(3l);
        System.out.println(one);

    }
    @Test
    public void testSave(){
        Customer customer=new Customer();
        customer.setCustPhone("1111111");
        customer.setCustIndustry("治理国家");
        customer.setCustAddress("秦国");
        customerDao.save(customer);
    }

    /**
     * 更新
     */
    @Test
    public void update(){
        Customer customer=new Customer();
        customer.setCustId(4l);
        customer.setCustSource("天地");
        customerDao.save(customer);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll(){
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 测试使用jpql根据名称查询结果
     */

    @Test
    public void findjpql(){
        Customer customer = customerDao.findCustomerByCustName("王爷");
        System.out.println(customer);
    }

    @Test
    public void findjpql2(){
        Customer customer = customerDao.findCustomerByCustNameAndCustId("王爷", 2l);
        System.out.println(customer);
    }
    @Test
    @Transactional
    @Rollback(value = false)
    public void updateJpql(){
        customerDao.updateCustomer(2l,"长信侯");
    }

    @Test
    public void findAllCustomer(){
        List<Customer> customerAll = customerDao.findCustomerAll();
        for (Customer customer : customerAll) {
            System.out.println(customer);
        }
    }
    @Test
    public void findCustomerByName(){
        List<Customer> customers = customerDao.findCustomerByName("%王%");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }



}
