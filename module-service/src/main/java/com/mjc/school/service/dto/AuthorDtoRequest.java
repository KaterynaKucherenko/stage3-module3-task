package com.mjc.school.service.dto;

import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.model.NewsModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorDtoRequest {

    private Long id;
    private String name;
    private List<Long> newsModelListWithId;

    public AuthorDtoRequest(){}
    public AuthorDtoRequest(Long id, String name, List<Long> newsModelListWithId){
        this.id=id;
        this.name=name;
        this.newsModelListWithId=newsModelListWithId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Long> getNewsModelListWithId() {
        return newsModelListWithId;
    }

    public void setNewsModelListWithId(List<Long> newsModelListWithId) {
        this.newsModelListWithId = newsModelListWithId;
    }
}