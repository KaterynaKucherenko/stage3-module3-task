package com.mjc.school.service.implementation;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.mapper.Mapper;
//import com.mjc.school.service.validation.ValidateNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("newsServiceImpl")
public class NewsServiceImpl implements NewsService {
    private NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsRepository.readAll().stream().map(Mapper.INSTANCE::ModelNewsToDTO).toList();
    }


    @Override
    public NewsDtoResponse readById(Long id) {
        Optional<NewsModel> opt = newsRepository.readById(id);
        return opt.map(Mapper.INSTANCE::ModelNewsToDTO).orElse(null);
    }

    //@ValidateNews
    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        return Mapper.INSTANCE.ModelNewsToDTO(newsRepository.create(Mapper.INSTANCE.DTONewsToModel(createRequest)));
    }

    // @ValidateNews
    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return Mapper.INSTANCE.ModelNewsToDTO(newsRepository.update(Mapper.INSTANCE.DTONewsToModel(updateRequest)));
    }

    @Override
    public boolean deleteById(Long id) {
        return newsRepository.deleteById(id);
    }

    @Override
    public List<NewsDtoResponse> getNewsByParams(String tagName, Long tagId, String authorName, String title, String content) {
        return newsRepository.getNewsByParams(tagName, tagId, authorName, title, content).stream().map(Mapper.INSTANCE::ModelNewsToDTO).collect(Collectors.toList());


    }
}