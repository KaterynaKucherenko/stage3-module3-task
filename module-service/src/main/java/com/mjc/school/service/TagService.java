package com.mjc.school.service;

import com.mjc.school.repository.model.TagModel;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;

import java.util.List;

public interface TagService extends BaseService<TagDtoRequest, TagDtoResponse, Long> {
    List<TagDtoResponse> readTagsByNewsId(Long newsId);
}
