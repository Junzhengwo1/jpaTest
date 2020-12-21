package com.kou.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author JIAJUN KOU
 * jpa工具类
 *
 * 解决实体管理器工厂浪费资源的问题：通过代码块来解决
 */
public class JpaUtils {
    private static EntityManagerFactory factory;

    static {
        //加载配置文件，创建entityManagerFactory
        factory = Persistence.createEntityManagerFactory("myJpa");

    }
    /**
     * 获取EntityManager对象
     */
    public static EntityManager getEntityManger(){
        return factory.createEntityManager();
    }

    /**
     * 释放资源
     */
    public static void turnOff(){
        factory.close();
    }
}
