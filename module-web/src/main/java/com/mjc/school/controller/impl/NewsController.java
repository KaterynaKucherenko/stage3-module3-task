package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotation.CommandBody;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.annotation.CommandParam;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("newsController")
public class NewsController implements BaseController<NewsDtoRequest, NewsDtoResponse, Long> {
    private final BaseService<NewsDtoRequest, NewsDtoResponse, Long> newsService;

    @Autowired
    public NewsController(BaseService<NewsDtoRequest, NewsDtoResponse, Long>  newsServiceImpl) {
        this.newsService = newsServiceImpl;
    }

    @CommandHandler("GetAllNews")
    @Override
    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    @CommandHandler("ReadNewsById")
    @Override
    public NewsDtoResponse readById(@CommandParam("newsId") Long id) {
        return newsService.readById(id);
    }

    @CommandHandler("CreateNews")
    @Override
    public NewsDtoResponse create(@CommandBody NewsDtoRequest createRequest) {
        return newsService.create(createRequest);
    }

    @CommandHandler("UpdateNews")
    @Override
    public NewsDtoResponse update(@CommandBody NewsDtoRequest updateRequest) {
        return newsService.update(updateRequest);
    }

    @CommandHandler("DeleteNews")
    @Override
    public boolean deleteById(@CommandParam("newsId") Long id) {
        return newsService.deleteById(id);
    }
}