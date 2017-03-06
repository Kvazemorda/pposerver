package com.pposerver.dao;

import com.pposerver.entity.Content;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

@Stateless
public class ContentDAO implements CRUD {

    public ContentDAO() {
    }

    public List<Content> getLastContent(long date, Session session){
        Date currentDate = new Date(date);

        String hql = "select content from Content content" +
                " where content.state = 1 " +
                " and content.created < :lastCreated" +
                " order by content.created desc";

        Query query = session.createQuery(hql);
        query.setParameter("lastCreated", currentDate);
        query.setMaxResults(10);
        return query.list();
    }

    public List<Content> getContentByTotalItemsCount(int totalItems, Session session){

        String hql = "select content from Content content" +
                " where content.state = 1 " +
                " order by content.created desc";

        Query query = session.createQuery(hql);
        query.setFirstResult(totalItems);
        query.setMaxResults(10);
        System.out.println("общее кол-во записей " + totalItems);
        return query.list();
    }

    public String test(){
        return "test";
    }
}
