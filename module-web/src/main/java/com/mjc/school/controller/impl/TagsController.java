package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;

import java.util.List;

public class TagsController implements BaseController<TagDtoRequest, TagDtoResponse, Long> {
    private BaseController<TagDtoRequest, TagDtoResponse, Long> tagsServiceImpl;

    public TagsController(BaseController<TagDtoRequest, TagDtoResponse, Long> tagsServiceImpl){
        this.tagsServiceImpl=tagsServiceImpl;
    }
    @CommandHandler("GetAllTags")
    @Override
    public List<TagDtoResponse> readAll() {
       return tagsServiceImpl.readAll();

    }
    @CommandHandler("ReadTagsById")
    @Override
    public TagDtoResponse readById(Long id) {
       return tagsServiceImpl.readById(id);
    }
    @CommandHandler("CreateTags")
    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        return tagsServiceImpl.create(createRequest);
    }
    @CommandHandler("UpdateTags")
    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        return tagsServiceImpl.update(updateRequest);
    }
    @CommandHandler("DeleteTags")
    @Override
    public boolean deleteById(Long id) {
        return tagsServiceImpl.deleteById(id);
    }
}
