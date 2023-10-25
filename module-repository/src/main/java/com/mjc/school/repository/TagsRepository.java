package com.mjc.school.repository;

import com.mjc.school.repository.model.TagModel;

import java.util.List;

public interface TagsRepository extends BaseRepository<TagModel, Long> {
    List<TagModel> readTagsByNewsId(Long newsId);
}
