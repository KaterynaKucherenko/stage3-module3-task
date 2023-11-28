package com.mjc.school.repository.model;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import javax.xml.transform.Source;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Component
@Table(name = "author")
public class AuthorModel implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 15)
    private String name;
    @CreatedDate
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastUpdateDate;
    @OneToMany(mappedBy = "authorModel", cascade = CascadeType.REMOVE)
    private List<NewsModel> newsModelListWithId = new ArrayList<>();

    public AuthorModel() {
    }

    public AuthorModel(Long id, String name, LocalDateTime createDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        AuthorModel authorModel = (AuthorModel) obj;
        return id == authorModel.id &&
                (name == authorModel.name || (name != null && name.equals(authorModel.getName()))) &&
                (createDate == authorModel.createDate || (createDate != null && createDate.equals(authorModel.getCreateDate()))) &&
                (lastUpdateDate == authorModel.lastUpdateDate || (lastUpdateDate != null && lastUpdateDate.equals(authorModel.getLastUpdateDate())));
    }

    public int hashCode() {
        return Objects.hash(id, name, createDate, lastUpdateDate);
    }

    public String toString() {
        return "Author's ID: " + id + ", author's name: " + name + ", create date: " + createDate + ", last update date: " + lastUpdateDate;
    }

    public List<NewsModel> getNewsModelListWithId() {
        return newsModelListWithId;
    }

    public void setNewsModelListWithId(List<NewsModel> newsModelListWithId) {
        this.newsModelListWithId = newsModelListWithId;
    }
}