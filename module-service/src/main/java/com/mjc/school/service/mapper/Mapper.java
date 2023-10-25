package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.model.TagModel;
import com.mjc.school.service.dto.*;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@org.mapstruct.Mapper
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    @Mappings(value = {@Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateDate", ignore = true), @Mapping(target ="authorModel") })
    NewsModel DTONewsToModel(NewsDtoRequest newsDtoRequest);

    NewsDtoResponse ModelNewsToDTO(NewsModel newsModel);

    @Mappings(value = {@Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateDate", ignore = true)})
    AuthorModel DTOAuthorToModel(AuthorDtoRequest authorDtoRequest);

    AuthorDtoResponse ModelAuthorToDTO(AuthorModel authorModel);
 TagModel DtoTagsToModel (TagDtoRequest tagDtoRequest);

 TagDtoResponse ModelTagsToDto (TagModel tagModel);


}