package com.pposerver.controller;

import com.google.gson.Gson;
import com.pposerver.dao.ContentDAO;
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

@WebServlet("/checkNew")
public class CheckerNewContentController extends HttpServlet {

    @EJB
    ContentDAO contentDAO;
    Session session = null;
    Transaction tx = null;


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        long date = Long.valueOf(httpServletRequest.getParameter("date"));
        session = HibernateSessionFactory.getSessionFactory().openSession();
        tx = session.beginTransaction();
        contentDAO = new ContentDAO();
        int sizeLastNew = contentDAO.checkNewContent(date, session);
        tx.commit();
        session.close();
        httpServletResponse.setContentType("application/json");
        httpServletRequest.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        PrintWriter out = httpServletResponse.getWriter();
        out.print(gson.toJson(sizeLastNew));
        out.flush();
        out.close();
    }
}
