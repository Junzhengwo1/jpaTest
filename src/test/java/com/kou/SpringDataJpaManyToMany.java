package com.kou;

import com.kou.dao.RoleDao;
import com.kou.dao.UserDao;
import com.kou.domain.Role;
import com.kou.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JIAJUN KOU
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJpaManyToMany {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd(){
        User user =new User();
        Role role=new Role();

        user.setUserName("蒙恬");
        role.setRoleName("蒙毅");

        user.getRoles().add(role);
        role.getUsers().add(user);
        userDao.save(user);
        roleDao.save(role);

    }

    /**
     * 测试级联操作
     * （保存一个用户的同时，保存用户关联的角色）
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCasCadeAdd(){
        User user =new User();
        Role role=new Role();

        user.setUserName("蒙恬");
        role.setRoleName("蒙毅");

        user.getRoles().add(role);
        role.getUsers().add(user);
        userDao.save(user);

    }
    /**
     * 测试级联操作
     * （删除一个用户的同时，删除用户关联的角色）
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCasCadeDelete(){

        User user = userDao.findOne(1l);
        userDao.delete(user);

    }


}
