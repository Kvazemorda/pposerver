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

    // добавить только включенные новости и из категории домашние




    @RequestMapping("/contentByDate")
    public List<Content> getListContentByDate(long date){
        long currentDate = date;
        return contentDAO.getContentByDate(currentDate);
    }

    @RequestMapping("/parser")
    public String getParser(long date){
        Content content = contentDAO.getLastContent().get(1);
        return "intro " + content.getIntrotext() + "\n\n" +  "fullText "+  content.getFulltext()  + "\n\n " + "image " + content.getImages();
    }
}
