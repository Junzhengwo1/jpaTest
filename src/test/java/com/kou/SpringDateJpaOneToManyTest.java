package com.kou;

import com.kou.dao.CustomerDao;
import com.kou.dao.LinkManDao;
import com.kou.domain.Customer;
import com.kou.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author JIAJUN KOU
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDateJpaOneToManyTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    /**
     * 保存一个联系人和一个客户
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void saveCustomerAndLinkMan(){
        Customer customer=new Customer();
        customer.setCustName("郭开");

        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("赵王");

        LinkMan linkMan1=new LinkMan();
        linkMan1.setLkmName("秦王");
        customer.getLinkMans().add(linkMan);
        customer.getLinkMans().add(linkMan1);
        customerDao.save(customer);
        linkManDao.save(linkMan);
        linkManDao.save(linkMan1);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveCustomerAndLinkMan2(){
        Customer customer=new Customer();
        customer.setCustName("李斯");
        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("秦王政");
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);

    }

    /**
     * 对象导航查询
     *
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testObjectForward(){

        //查询客户id为1的客户;getOne采用的延迟加载。
        Customer customer = customerDao.getOne(1l);
        System.out.println(customer);
        //通过对象导航查询，查询出所对应的联系人
        Set<LinkMan> linkMans = customer.getLinkMans();
        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }

    }
    /**
     * 对象导航查询
     * 从联系人对象导航查询出他的所属客户
     *
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testObjectForward2(){


        LinkMan linkMan1 = linkManDao.getOne(2l);
        Customer customer = linkMan1.getCustomer();
        System.out.println(customer);
    }


}
