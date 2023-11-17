package com.mjc.school.repository.implementation;

import com.mjc.school.repository.AuthRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository("authorRepository")
public class AuthorRepository implements AuthRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public AuthorRepository(){}


    @Override
    public List<AuthorModel> readAll() {
        List<AuthorModel> result = entityManager.createQuery("SELECT a from AuthorModel a", AuthorModel.class).getResultList();
        return result;
    }


    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.ofNullable((AuthorModel) entityManager.createQuery("SELECT a FROM AuthorModel a WHERE a.id = :id", AuthorModel.class).setParameter("id", id).getSingleResult());
    }


    @Override
    public AuthorModel create(AuthorModel authorModel) {
        entityManager.persist(authorModel);
        return authorModel;
    }

    @Override
    public AuthorModel update(AuthorModel authorModel) {
        return entityManager.merge(authorModel);
    }


    @Override
    public boolean deleteById(Long id) {
        AuthorModel authorModel = entityManager.getReference(AuthorModel.class, id);
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
        AuthorModel exist = entityManager.getReference(AuthorModel.class, id);
        return exist != null;
    }


    public AuthorModel getAuthorByNewsId(Long newsId) {
        NewsModel newsModel = entityManager.find(NewsModel.class, newsId);
        if (newsModel != null) {
            return entityManager.getReference(AuthorModel.class, newsModel.getAuthorId());
        }
        throw new EntityNotFoundException("News with " + newsId + " ID not found");
    }
}