package com.kou;

import com.kou.domain.Customer;
import com.kou.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author JIAJUN KOU
 */
public class jpaTest {
    /**
     * 保存数据到数据库中
     */
    @Test
    public void testSave(){
        EntityManagerFactory myJpaFactory = Persistence.createEntityManagerFactory("myJpa");
        //得到实体管理器
        EntityManager entityManager = myJpaFactory.createEntityManager();
        //获取事务对象，开启事务
        EntityTransaction tx=entityManager.getTransaction();
        //开启事务
        tx.begin();
        //完成相关操作
        Customer customer=new Customer();
        customer.setCustName("王爷");
        customer.setCustIndustry("管理魏国");
        customer.setCustPhone("1234644446");
        //保存操作
        entityManager.persist(customer);
        //提交事务
        tx.commit();
        //释放资源
        entityManager.close();
        myJpaFactory.close();
    }
    @Test
    public void testSave2(){
        EntityManager entityManager = JpaUtils.getEntityManger();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        //完成相关操作
        Customer customer=new Customer();
        customer.setCustName("太后");
        customer.setCustIndustry("执掌后宫");
        customer.setCustPhone("1234644446");
        //保存操作
        entityManager.persist(customer);
        //提交事务
        tx.commit();
        //释放资源
        entityManager.close();
    }

    /**
     * 根据id查询
     */
    @Test
    public void testFind(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction tx = entityManger.getTransaction();
        tx.begin();
        //find方法第一个对象是，需要封装的对象
        Customer customer = entityManger.find(Customer.class, 2l);
        System.out.println(customer);
        tx.commit();
        entityManger.close();

    }
    @Test
    public void testReference(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction tx = entityManger.getTransaction();
        tx.begin();
        //find方法第一个对象是，需要封装的对象
        Customer customer = entityManger.getReference(Customer.class, 2l);
        System.out.println(customer);
        tx.commit();
        entityManger.close();

    }
    @Test
    public void testDelete(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction tx = entityManger.getTransaction();
        tx.begin();
        Customer customer = entityManger.getReference(Customer.class, 1l);
        entityManger.remove(customer);
        tx.commit();
        entityManger.close();

    }

}
