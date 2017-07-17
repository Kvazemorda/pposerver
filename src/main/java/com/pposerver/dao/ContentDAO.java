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

    public List<Content> getContentByTotalItemsCount(int totalItems, Session session){

        String hql = "select content from Content content" +
                //" where content.state = 1 " +
                " where (content.catid = 2 or content.catid = 14)  " +
                "order by content.modified desc";

        Query query = session.createQuery(hql);
        query.setFirstResult(totalItems);
        query.setMaxResults(10);
        return query.list();
    }

    public int checkNewContent(long date, Session session){
        String hql = "select content from Content content " +
               // " where content.state = 1 " +
                " where content.modified > :lastNew " +
                " and (content.catid = 2 or content.catid = 14) ";
        System.out.println(new Date(1499874463000l));
        Query query = session.createQuery(hql);
        query.setParameter("lastNew", new Date(date));
        return query.list().size();
    }
}
