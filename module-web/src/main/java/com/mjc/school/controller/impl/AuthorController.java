package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotation.CommandBody;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.annotation.CommandParam;
import com.mjc.school.service.AuthorService;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("authorController")
public class AuthorController implements BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorServiceImpl) {
        this.authorService = authorServiceImpl;
    }

    @CommandHandler("7")
    @Override
    public List<AuthorDtoResponse> readAll() {
        return authorService.readAll();
    }

    @CommandHandler("8")
    @Override
    public AuthorDtoResponse readById(@CommandParam("authorId") Long id) {
        return authorService.readById(id);
    }

    @CommandHandler("9")
    @Override
    public AuthorDtoResponse create(@CommandBody AuthorDtoRequest createRequest) {
        return authorService.create(createRequest);
    }

    @CommandHandler("10")
    @Override
    public AuthorDtoResponse update(@CommandBody AuthorDtoRequest updateRequest) {
        return authorService.update(updateRequest);
    }

    @CommandHandler("11")
    @Override
    public boolean deleteById(@CommandParam("authorId") Long id) {
        return authorService.deleteById(id);
    }
}