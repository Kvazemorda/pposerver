package com.pposerver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pposerver.dao.ContentDAO;
import com.pposerver.entity.Content;
import com.pposerver.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/contentByTotalItems")
public class ContentController extends HttpServlet{
    @EJB ContentDAO contentDAO;

    Session session = null;
    Transaction tx = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int totalItems = Integer.valueOf(req.getParameter("totalItems"));
            int maxResult = Integer.valueOf(req.getParameter("maxResult"));
        session = HibernateSessionFactory.getSessionFactory().openSession();
        tx = session.beginTransaction();
        contentDAO = new ContentDAO();
        List<Content> list = contentDAO.getContentByTotalItemsCount(totalItems, maxResult, session);
        tx.commit();
        session.close();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(list));
        out.flush();
        out.close();
    }

}
