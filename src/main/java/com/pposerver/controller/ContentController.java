package com.pposerver.controller;

import com.pposerver.dao.ContentDAO;
import com.pposerver.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contentByTotalItems")
public class ContentController extends HttpServlet{
    @EJB ContentDAO contentDAO;

    Session session = null;
    Transaction tx = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalItems = Integer.valueOf(req.getParameter("totalItems"));
        session = HibernateSessionFactory.getSessionFactory().openSession();
        tx = session.beginTransaction();

        //List<Content> list = contentDAO.getContentByTotalItemsCount(totalItems, session);
        PrintWriter print = resp.getWriter();
        print.print(contentDAO.test());
        tx.commit();
        session.close();
        resp.setContentType("application/json");
        JSONObject jsonObject = new JSONObject();
        try {
          //  jsonObject.put("list", list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }

}
