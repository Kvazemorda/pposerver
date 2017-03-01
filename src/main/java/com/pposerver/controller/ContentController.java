package com.pposerver.controller;

import com.pposerver.dao.ContentDAO;
import com.pposerver.entity.Content;
import com.pposerver.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {

    @Autowired
    ContentDAO contentDAO;

    Session session = null;
    Transaction tx = null;


    @RequestMapping("/content")
    public List<Content> getListContent(long date){
        session = HibernateSessionFactory.getSessionFactory().openSession();
        tx = session.beginTransaction();
        List<Content> list = contentDAO.getLastContent(date, session);
        tx.commit();
        session.close();
        return list;
    }

    @RequestMapping("/contentByTotalItems")
    public List<Content> getListContent(int totalItems){
        session = HibernateSessionFactory.getSessionFactory().openSession();
        tx = session.beginTransaction();
        List<Content> list = contentDAO.getContentByTotalItemsCount(totalItems, session);
        tx.commit();
        session.close();
        return list;
    }

}
