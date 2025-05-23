package com.daenamu.drama.service;

import com.daenamu.drama.dto.DramaResponseDto;
import com.daenamu.drama.dto.EpisodeResponseDto;
import com.daenamu.drama.feign.EpisodeClient;
import com.daenamu.drama.repository.DramaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DramaService {

    private final DramaRepository dramaRepository;
    private final EpisodeClient episodeClient;

    public List<DramaResponseDto> getAllDramas(){
        return dramaRepository.findAll().stream().map(
                drama-> {
                    List<EpisodeResponseDto> episodes = episodeClient.getEpisodesByDramaId(drama.getId());
                    return new DramaResponseDto(drama, episodes);
                }
        ).toList();
    }

    public DramaResponseDto getDramaById(Long dramaId){
        return dramaRepository.findById(dramaId).map(drama -> {
            List<EpisodeResponseDto> episodeResponseDtos = episodeClient.getEpisodesByDramaId(drama.getId());
            return new DramaResponseDto(drama, episodeResponseDtos);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 드라마를 찾을 수 없습니다."));
    }
}
