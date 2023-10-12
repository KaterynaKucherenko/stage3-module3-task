package com.mjc.school.service.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.implementation.AuthorRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.mapper.Mapper;
import com.mjc.school.service.validation.ValidateAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("authorServiceImpl")
public class AuthorServiceImpl implements BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> {
    private BaseRepository<AuthorModel, Long> authorRepository;

    @Autowired
    public AuthorServiceImpl(BaseRepository<AuthorModel, Long> authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        return authorRepository.readAll().stream().map(Mapper.INSTANCE::ModelAuthorToDTO).toList();
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        Optional<AuthorModel> opt = authorRepository.readById(id);
        return opt.map(Mapper.INSTANCE::ModelAuthorToDTO).orElse(null);
    }

    @ValidateAuthor
    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        return Mapper.INSTANCE.ModelAuthorToDTO(authorRepository.create(Mapper.INSTANCE.DTOAuthorToModel(createRequest)));
    }

    @ValidateAuthor
    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {

        return Mapper.INSTANCE.ModelAuthorToDTO(authorRepository.update(Mapper.INSTANCE.DTOAuthorToModel(updateRequest)));
    }

    @Override
    public boolean deleteById(Long id) {
        return authorRepository.deleteById(id);
    }
}