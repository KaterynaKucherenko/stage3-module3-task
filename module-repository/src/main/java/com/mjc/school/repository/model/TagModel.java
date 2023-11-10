package com.mjc.school.repository.model;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Component
@Table(name = "TAGS")
public class TagModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TAGS_NAME")
    @Size(min = 3, max = 15)
    private String name;

    @ManyToMany(mappedBy = "news", fetch = FetchType.LAZY)
    private List<NewsModel> news = new ArrayList<>();

    public TagModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<NewsModel> getNews() {
        return news;
    }

    public void setNews(List<NewsModel> news) {
        this.news = news;
    }
}
