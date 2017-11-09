package com.xs.study.hibernate;

import com.xs.study.hibernate.model.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.List;

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
        personEntity.setName("王武");
        personEntity.setSex((byte)1);
        
        session.save(personEntity);
        session.getTransaction().commit();;
        session.close();
    }

    @Test
    public void testQuery() {
        Session session = sessionFactory.openSession();
        List<PersonEntity> list = session.createQuery("from PersonEntity").list();
        
        session.q
        
        for(PersonEntity personEntity:list){
            System.out.println(personEntity.toString());
        }
        session.close();
    }
    
    
    
}
