package com.mjc.school.repository.aspects;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.datasourse.AuthorDataSource;
import com.mjc.school.repository.datasourse.NewsDataSource;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.model.NewsModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class OnDeleteAspect {
    private BaseRepository<NewsModel, Long> newsRepository;

    @Autowired
    public OnDeleteAspect(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Pointcut("within(com.mjc.school.repository.implementation.AuthorRepository) && @annotation(com.mjc.school.repository.aspects.OnDelete)")
    public void hasAnnot() {
    }


    @After(value = "hasAnnot() && args(id)")
    public void OnDelete(JoinPoint joinPoint, Long id) {
        List<NewsModel> newsFiltered = newsRepository.readAll().stream().filter(newsModel -> newsModel.getAuthorId().equals(id)).toList();
        newsFiltered.forEach(NewsModel -> newsRepository.deleteById(NewsModel.getId()));

    }
}