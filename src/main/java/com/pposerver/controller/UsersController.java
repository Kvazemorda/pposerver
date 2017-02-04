package com.pposerver.controller;

import com.pposerver.dao.UsersDAO;
import com.pposerver.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersDAO usersDAO;
    public static Users users;

    @RequestMapping("/persons")
    public List<Users> getAllPerson(){
        List<Users> listPersons = usersDAO.getAllPerson();
        System.out.println(listPersons);
        return listPersons;
    }
}
