package com.pposerver.controller;

import com.pposerver.dao.UsersDAO;
import com.pposerver.entity.Users;

import java.util.List;

public class UsersController {

    UsersDAO usersDAO;
    public static Users users;

    public List<Users> getAllPerson(long date){
        List<Users> listPersons = usersDAO.getAllPerson();
        return listPersons;
    }
}
