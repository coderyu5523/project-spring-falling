package org.example.projectspringfalling.song;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongService {
    private final SongRepository songRepository;


    public Song getImg(int id){
       Song song = songRepository.findById(id).get();
       return song;
    }
}
