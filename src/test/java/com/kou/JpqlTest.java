package com.kou;

import com.kou.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author JIAJUN KOU
 *
 * 测试Jpql查询:
 */
public class JpqlTest {
    /**
     * 使用jpql来查询所有
     */
    @Test
    public void findAll(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction tx = entityManger.getTransaction();
        tx.begin();
        String jpql="from com.kou.domain.Customer";
        Query query = entityManger.createQuery(jpql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        tx.commit();
        entityManger.close();
    }
}
