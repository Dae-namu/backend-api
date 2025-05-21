package com.daenamu.episode.service;

import com.daenamu.episode.dto.EpisodeResponseDto;
import com.daenamu.episode.entity.Episode;
import com.daenamu.episode.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    public List<EpisodeResponseDto> getEpisodesByDramaId(Long dramaId){
        return episodeRepository.findByDramaId(dramaId)
                .stream().map(EpisodeResponseDto::new).collect(Collectors.toList());
    }

    public EpisodeResponseDto getEpisodeByDramaIdAndEpisodeId(Long dramaId, Long episodeId){
        Episode episode = episodeRepository.findById(episodeId).filter(e -> e.getDramaId().equals(dramaId))
                .orElseThrow(()-> new RuntimeException("해당 회차를 찾을 수 없습니다."));
        return new EpisodeResponseDto(episode);
    }
}
