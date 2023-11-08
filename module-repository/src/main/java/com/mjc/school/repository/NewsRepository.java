package com.mjc.school.repository;

import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public interface NewsRepository extends BaseRepository<NewsModel, Long> {
    List<NewsModel> getNewsByParams(String tagName, Long tagId, String authorName, String title, String content);
}
