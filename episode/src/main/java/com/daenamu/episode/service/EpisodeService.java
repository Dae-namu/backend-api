package com.daenamu.episode.service;

import com.daenamu.episode.dto.EpisodeResponseDto;
import com.daenamu.episode.dto.StreamResponseDto;
import com.daenamu.episode.entity.Episode;
import com.daenamu.episode.feign.StreamClient;
import com.daenamu.episode.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;
    private final StreamClient streamClient;

    public List<EpisodeResponseDto> getEpisodesByDramaId(Long dramaId){
//        return episodeRepository.findByDramaId(dramaId).stream().map(
//                episode -> {
//                    String streamUrl = streamClient.getStreamByEpisodeId(episode.getId()).getStreamUrl();
//                    return new EpisodeResponseDto(episode, streamUrl);
//                }
//        ).collect(Collectors.toList());
        return episodeRepository.findByDramaId(dramaId).stream().map(
                episode -> {
                    String streamUrl = null;
                    try {
                        StreamResponseDto stream = streamClient.getStreamByEpisodeId(episode.getId());
                        streamUrl = stream.getStreamUrl();
                        System.out.println("✅ streamUrl for episodeId " + episode.getId() + ": " + streamUrl);
                    } catch (Exception e) {
                        System.out.println("🚨 Feign 오류 발생: " + e.getMessage());
                    }
                    return new EpisodeResponseDto(episode, streamUrl);
                }
        ).collect(Collectors.toList());
    }

    public EpisodeResponseDto getEpisodeByDramaIdAndEpisodeId(Long dramaId, Long episodeId){
        Episode episode = episodeRepository.findById(episodeId)
                .filter(e -> e.getDramaId().equals(dramaId))
                .orElseThrow(() -> new RuntimeException("해당 회차를 찾을 수 없습니다."));
        String streamUrl = streamClient.getStreamByEpisodeId(episodeId).getStreamUrl();
        return new EpisodeResponseDto(episode, streamUrl);
    }
}
