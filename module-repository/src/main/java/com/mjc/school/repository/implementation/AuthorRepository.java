package com.mjc.school.repository.implementation;

import com.mjc.school.repository.AuthRepository;
import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("authorRepository")
public class AuthorRepository implements AuthRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<AuthorModel> readAll() {
        List<AuthorModel> result = entityManager.createQuery("SELECT a from AuthorModel a", AuthorModel.class).getResultList();
        return result;
    }

    @Transactional
    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.ofNullable((AuthorModel) entityManager.createQuery("FROM AuthorModel a WHERE a.id = :id"));
    }

    @Transactional
    @Override
    public AuthorModel create(AuthorModel authorModel) {
        entityManager.persist(authorModel);
        return authorModel;
    }

    @Transactional
    @Override
    public AuthorModel update(AuthorModel authorModel) {
        AuthorModel tmp = readById(authorModel.getId()).get();
        tmp.setName(authorModel.getName());
        //entityManager.merge(authorModel);
        return tmp;
    }

    @Transactional
    @Override
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

    @Transactional
    @Override
    public boolean existById(Long id) {
        AuthorModel exist = entityManager.find(AuthorModel.class, id);
        return exist != null;
    }

    @Transactional
    public AuthorModel getAuthorByNewsId(Long newsId) {
        NewsModel newsModel = entityManager.getReference(NewsModel.class, newsId);
        if (newsModel != null) {
            return entityManager.getReference(AuthorModel.class, newsModel.getAuthorId());
        }
        throw new RuntimeException();
    }
}