package com.mjc.school.service.implementation;

import com.mjc.school.repository.TagsRepository;
import com.mjc.school.repository.model.TagModel;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import com.mjc.school.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("tagsServiceImpl")
public class TagsServiceImpl implements TagService {
    private final TagsRepository tagsRepository;

    @Autowired
    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public List<TagDtoResponse> readAll() {
        return tagsRepository.readAll().stream().map(Mapper.INSTANCE::ModelTagsToDto).toList();
    }

    @Override
    public TagDtoResponse readById(Long id) {
        Optional<TagModel> opt = tagsRepository.readById(id);
        return opt.map(Mapper.INSTANCE::ModelTagsToDto).orElse(null);
    }

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        return Mapper.INSTANCE.ModelTagsToDto(tagsRepository.create(Mapper.INSTANCE.DtoTagsToModel(createRequest)));
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        return Mapper.INSTANCE.ModelTagsToDto(tagsRepository.update(Mapper.INSTANCE.DtoTagsToModel(updateRequest)));
    }

    @Override
    public boolean deleteById(Long id) {
        return tagsRepository.deleteById(id);

    }

    @Override
    public List<TagDtoResponse> readTagsByNewsId(Long newsId) {
        return tagsRepository.readTagsByNewsId(newsId).stream().map(Mapper.INSTANCE::ModelTagsToDto).toList();
    }
}
