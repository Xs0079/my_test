package com.xs.study.hibernate;

import com.xs.study.hibernate.model.PersonEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by Xu Sheng on 2017/11/9.
 * hibernate Test类
 */
public class HibernateTest {

    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void testInsert() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("王武1" + new Random().nextInt());
        personEntity.setSex((byte) 1);

        session.save(personEntity);
        session.getTransaction().commit();
        ;
        session.close();
    }

    @Test
    public void testQuery() {
        Session session = sessionFactory.openSession();
        List<PersonEntity> list = session.createQuery("from PersonEntity").list();

        for (PersonEntity personEntity : list) {
            System.out.println(personEntity.toString());
        }
        session.close();
    }

    @Test
    public void testCriteriaQuery() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(PersonEntity.class);
        criteria.add(Restrictions.eq("name", "张三"));
        List<PersonEntity> list = criteria.list();
        for (PersonEntity personEntity : list) {
            System.out.println(personEntity);
        }


        //复杂查询 使用离线的Criteria
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonEntity.class);
        detachedCriteria.add(Restrictions.or(Restrictions.eq("sex", (byte) 1),
                Restrictions.eq("name", "李四")));
        
        list = detachedCriteria.getExecutableCriteria(session).list();
        for (PersonEntity personEntity : list) {
            System.out.println(personEntity);
        }

    }


}
