package com.example.musicapplication.repository;

import com.example.musicapplication.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> getAll();
    void add(Music music);
    Music findByID(int id);
    void updateMusic(Music music);
    void delete(int id);
    List<Music> searchName(String keywork);
}
