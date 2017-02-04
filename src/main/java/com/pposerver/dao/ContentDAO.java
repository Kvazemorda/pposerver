package com.pposerver.dao;

import com.pposerver.entity.Content;
import com.pposerver.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContentDAO implements CRUD {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public List<Content> getLastContent(){
        String hql = "select content from Content content order by content.created desc";

        Query query = session.createQuery(hql);
        query.setMaxResults(5);
        return query.list();
    }
}
