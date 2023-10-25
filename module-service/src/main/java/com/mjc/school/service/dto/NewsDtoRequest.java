package com.mjc.school.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDtoRequest {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private List<Long> tagsId;


//    public NewsDtoRequest(String title, String content, Long authorId) {
//        this.title = title;
//        this.content = content;
//        this.authorId = authorId;
//    }
//
//    public NewsDtoRequest(Long id, String title, String content, Long authorId) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.authorId = authorId;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Long> getTagsId(){
        return tagsId;
    }
    public void setTagsId (List<Long>tagsId){
        this.tagsId=tagsId;
    }
}
