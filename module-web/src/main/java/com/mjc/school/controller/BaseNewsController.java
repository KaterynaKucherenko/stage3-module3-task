package com.mjc.school.controller;

import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.List;

public interface BaseNewsController extends BaseController<NewsDtoRequest, NewsDtoResponse, Long> {
    List<NewsDtoResponse> getNewsByParams(String tagName, Long tagId, String authorName, String title, String content);
}
