package com.example.musicapplication.service;

import com.example.musicapplication.model.Music;
import com.example.musicapplication.repository.IMusicRepository;
import com.example.musicapplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository musicRepository;
    @Override
    public List<Music> getAll() {
        return musicRepository.getAll();
    }

    @Override
    public void add(Music music) {
        musicRepository.add(music);
    }

    @Override
    public Music findByID(int id) {
        return musicRepository.findByID(id);
    }

    @Override
    @Transactional
    public void updateMusic(Music music) {
        musicRepository.updateMusic(music);
    }

    @Override
    public List<Music> searchName(String keywork) {
        return musicRepository.searchName(keywork);
    }

}
