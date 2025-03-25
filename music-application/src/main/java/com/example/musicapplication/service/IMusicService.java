package com.example.musicapplication.service;

import com.example.musicapplication.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAll();
    void add(Music music);
    Music findByID(int id);
    void updateMusic(Music music);
    List<Music> searchName(String keywork);
}
