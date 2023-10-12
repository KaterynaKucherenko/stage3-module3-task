package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.aspects.OnDelete;
import com.mjc.school.repository.datasourse.AuthorDataSource;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository("authorRepository")
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<AuthorModel> readAll() {
        List<AuthorModel> result = entityManager.createQuery("SELECT a from AuthorModel a", AuthorModel.class).getResultList();
        return result;
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.ofNullable((AuthorModel) entityManager.createQuery("FROM AuthorModel a WHERE a.id = :id"));
    }

    @Override
    public AuthorModel create(AuthorModel authorModel) {
        entityManager.persist(authorModel);
        return authorModel;
    }

    @Override
    public AuthorModel update(AuthorModel authorModel) {
        entityManager.merge(authorModel);
        return authorModel;
    }

    @Override
    @OnDelete
    public boolean deleteById(Long id) {
        AuthorModel authorModel = entityManager.find(AuthorModel.class, id);
        try {
            entityManager.remove(authorModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean existById(Long id) {
        AuthorModel exist = entityManager.find(AuthorModel.class, id);
        return exist != null;
    }

    public AuthorModel getAuthorByNewsId(Long newsId) {
        NewsModel newsModel = entityManager.getReference(NewsModel.class, newsId);
        if (newsModel != null) {
            return entityManager.getReference(AuthorModel.class, newsModel.getAuthorId());
        }
        throw new RuntimeException();
    }
}