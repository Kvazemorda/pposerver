package com.pposerver.dao;

import com.pposerver.entity.Content;
import com.pposerver.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class ContentDAO implements CRUD {

    public List<Content> getLastContent(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        String hql = "select content from Content content" +
                " where content.state = 1 " +
                " order by content.created desc";

        Query query = session.createQuery(hql);
        query.setMaxResults(5);
        return query.list();
    }

    public List<Content> getContentByDate(long date){
        Date currentDate = new Date(date);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        String hql = "select content from Content content " +
                "where content.created < :date  " +
                "order by content.created desc";

        Query query = session.createQuery(hql);
        query.setParameter("date", currentDate);
        query.setMaxResults(5);
        return query.list();
    }
}
