package com.daenamu.episode.dto;

import com.daenamu.episode.entity.Episode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class EpisodeResponseDto {
    private Long id;
    private String title;
    private String episodeDescription;
    private LocalDateTime broadcastDate;
    private String image;
    private String streamUrl;


    public EpisodeResponseDto(Episode episode, String streamUrl){
        this.id = episode.getId();
        this.title = episode.getTitle();
        this.episodeDescription = episode.getEpisodeDescription();
        this.broadcastDate = episode.getBroadcastDate();
        this.image = episode.getImage();
        this.streamUrl = streamUrl;
    }
}
