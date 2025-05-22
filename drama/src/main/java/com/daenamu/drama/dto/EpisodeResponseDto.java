package com.daenamu.drama.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class EpisodeResponseDto {

    private Long id;
    private String title;
    private String episodeDescription;
    private LocalDateTime broadcastDate;
    private String image;
    private String streamUrl;

    public EpisodeResponseDto() {}

}
