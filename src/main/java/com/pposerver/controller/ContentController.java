package com.pposerver.controller;

import com.pposerver.dao.ContentDAO;
import com.pposerver.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {

    @Autowired
    ContentDAO contentDAO;

    @RequestMapping("/content")
    public List<Content> getListContent(){
        return contentDAO.getLastContent();
    }
}
