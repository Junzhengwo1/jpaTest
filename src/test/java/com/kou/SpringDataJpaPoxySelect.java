package com.kou;

import com.kou.dao.CustomerDao;
import com.kou.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import javax.swing.text.html.HTMLDocument;

/**
 * @author JIAJUN KOU
 *
 * spec对象的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJpaPoxySelect {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 查询单个对象，根据条件查询
     */
    @Test
    public void findAll(){
        /**
         * 自定义查询条件
         */
        Specification<Customer> spec=new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取比较的属性
                Path<Object> custName = root.get("custName");
                //构造查询条件
                Predicate predicate = criteriaBuilder.equal(custName, "寇爷爷");//精准匹配

                return predicate;
            }
        };
        Customer one = customerDao.findOne(spec);
        System.out.println(one);

    }
    @Test
    public void Spec(){
        /**
         * 自定义查询条件
         */
        Specification<Customer> spec=new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取比较的属性
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");
                //构造查询条件
                Predicate predicate = criteriaBuilder.equal(custName, "王爷");//精准匹配
                Predicate predicate1 = criteriaBuilder.equal(custIndustry, "管理魏国");

                //多个条件联合查询
                Predicate and = criteriaBuilder.and(predicate, predicate1);
                return and;
            }
        };
        Customer one = customerDao.findOne(spec);
        System.out.println(one);

    }


}
