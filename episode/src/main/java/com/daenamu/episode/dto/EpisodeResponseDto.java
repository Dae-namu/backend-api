package com.daenamu.episode.dto;

import com.daenamu.episode.entity.Episode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EpisodeResponseDto {
    private Long id;
    private String title;
    private String episodeDescription;
    private LocalDateTime broadcastDate;
    private String image;


    public EpisodeResponseDto(Episode episode){
        this.id = episode.getId();
        this.title = episode.getTitle();
        this.episodeDescription = episode.getEpisodeDescription();
        this.broadcastDate = episode.getBroadcastDate();
        this.image = episode.getImage();
    }
}
