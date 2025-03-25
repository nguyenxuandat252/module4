package com.example.musicapplication.repository;

import com.example.musicapplication.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MusicRepository implements IMusicRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> getAll() {
        TypedQuery<Music> typedQuery = (TypedQuery<Music>) entityManager.createQuery("from Music");
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void add(Music music) {
        entityManager.merge(music);
    }

    @Override
    public Music findByID(int id) {
        return entityManager.find(Music.class,id);
    }

    @Override
    public void updateMusic(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(int id) {
        Music music = findByID(id);
        if(music!=null){
            entityManager.remove(music);
        }
    }

    @Override
    public List<Music> searchName(String keywork) {
        TypedQuery<Music> query = entityManager.createQuery(
                "SELECT m FROM Music m WHERE LOWER(m.name) LIKE LOWER(:name)", Music.class);
        query.setParameter("name", "%" + keywork + "%");
        return query.getResultList();
    }
}
