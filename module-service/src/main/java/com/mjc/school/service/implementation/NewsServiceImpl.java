package com.mjc.school.service.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.datasourse.NewsDataSource;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.mapper.Mapper;
import com.mjc.school.service.validation.ValidateNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("newsServiceImpl")
public class NewsServiceImpl implements BaseService<NewsDtoRequest, NewsDtoResponse, Long> {
    private BaseRepository<NewsModel, Long> newsRepository;

    @Autowired
    public NewsServiceImpl(BaseRepository<NewsModel, Long> newsRepository) {
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

    @ValidateNews
    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        return Mapper.INSTANCE.ModelNewsToDTO(newsRepository.create(Mapper.INSTANCE.DTONewsToModel(createRequest)));
    }

    @ValidateNews
    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return Mapper.INSTANCE.ModelNewsToDTO(newsRepository.update(Mapper.INSTANCE.DTONewsToModel(updateRequest)));
    }

    @Override
    public boolean deleteById(Long id) {
        return newsRepository.deleteById(id);
    }
}