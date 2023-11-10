package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements com.mjc.school.repository.NewsRepository {
    @PersistenceContext
    private EntityManager entityManager;
@Autowired
    public NewsRepository(){
    }


    @Override
    public List<NewsModel> readAll() {
        List<NewsModel> result = entityManager.createQuery("SELECT n from NewsModel n", NewsModel.class).getResultList();
        return result;
    }


    @Override
    public Optional<NewsModel> readById(Long id) {
        return Optional.ofNullable((NewsModel) entityManager.createQuery("SELECT a FROM NewsModel a WHERE a.id = :id").setParameter("id", id).getSingleResult());
    }


    @Override
    public NewsModel create(NewsModel newsModel) {
        entityManager.persist(newsModel);
        return newsModel;
    }


    @Override
    public NewsModel update(NewsModel newsModel) {
        entityManager.merge(newsModel);
        return newsModel;
    }


    @Override
    public boolean deleteById(Long id) {
        NewsModel newsModel = entityManager.getReference(NewsModel.class, id);
        try {
            entityManager.remove(newsModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean existById(Long id) {
        NewsModel exist = entityManager.getReference(NewsModel.class, id);
        return exist != null;
    }


    @Override
    public List<NewsModel> getNewsByParams(String tagName, Long tagId, String authorName, String title, String content) {
        StringBuilder paramsForNews = new StringBuilder("SELECT n FROM NewsModel n WHERE 1=1");
        if (tagName != null && !tagName.isEmpty()) {
            paramsForNews.append(" AND n.tagName = :tagName");
        }
        if (tagId != null) {
            paramsForNews.append(" AND n.tagId = :tagId");
        }
        if (authorName != null && !authorName.isEmpty()) {
            paramsForNews.append(" AND n.authorName = :authorName");
        }
        if (title != null && !title.isEmpty()) {
            paramsForNews.append("AND n.title = :title");
        }
        if (content != null && !content.isEmpty()) {
            paramsForNews.append(" AND n.content = :content");
        }
        TypedQuery<NewsModel> query = entityManager.createQuery(paramsForNews.toString(), NewsModel.class);
        if (tagName != null && !tagName.isEmpty()) {
            query.setParameter("tagName", tagName);
        }
        if (tagId != null) {
            query.setParameter("tagId", tagId);
        }

        if (authorName != null && !authorName.isEmpty()) {
            query.setParameter("authorName", authorName);
        }
        if (title != null && !title.isEmpty()) {
            query.setParameter("title", title);
        }
        if (content != null && !content.isEmpty()) {
            query.setParameter("content", content);
        }
        return query.getResultList();
    }

}