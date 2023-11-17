package com.mjc.school.controller.impl;


import com.mjc.school.controller.BaseNewsController;
import com.mjc.school.controller.annotation.CommandBody;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.annotation.CommandParam;

import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("newsController")
public class NewsController implements BaseNewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @CommandHandler("1")
    @Override
    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    @CommandHandler("2")
    @Override
    public NewsDtoResponse readById(@CommandParam("newsId") Long id) {
        return newsService.readById(id);
    }

    @CommandHandler("3")
    @Override
    public NewsDtoResponse create(@CommandBody NewsDtoRequest createRequest) {
        return newsService.create(createRequest);
    }

    @CommandHandler("4")
    @Override
    public NewsDtoResponse update(@CommandBody NewsDtoRequest updateRequest) {
        return newsService.update(updateRequest);
    }

    @CommandHandler("5")
    @Override
    public boolean deleteById(@CommandParam("newsId") Long id) {
        return newsService.deleteById(id);
    }

    @CommandHandler("6")
    @Override
    public List<NewsDtoResponse> getNewsByParams(String tagName, Long tagId, String authorName, String title, String content) {
        List<NewsDtoResponse> news = newsService.getNewsByParams(tagName, tagId, authorName, title, content);
        return news;
    }
}