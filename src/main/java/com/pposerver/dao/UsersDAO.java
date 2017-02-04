package com.pposerver.dao;

import com.pposerver.entity.Users;
import com.pposerver.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class UsersDAO {

    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public List<Users> getAllPerson(){
        Query query = session.createQuery("select person from Users person");
        return query.list();
    }

    public boolean personIsExist(long id){
        String hql = "select distinct person from Users person " +
                "where person.id = :personComing";

        Query query = session.createQuery(hql);
        query.setParameter("personComing", id);
        Users personExist = (Users) query.list().get(0);
        if(personExist != null && id == personExist.getId()){
            return true;
        }
        else return false;
    }

    /**
     *  Get current person by id
     * @param id long
     * @return
     */
    public Users getPersonEntity(long id){
        String hql = "select distinct person from Users person " +
                "where person.id = :personComing";

        Query query = session.createQuery(hql);
        query.setParameter("personComing", id);
        Users personExist = (Users) query.list().get(0);

        return personExist;
    }
}
