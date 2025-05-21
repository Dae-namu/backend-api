package com.daenamu.drama.dto;

import com.daenamu.drama.entity.Drama;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class DramaResponseDto {

    private Long id;
    private String title;
    private String thumbnailUrl;
    private String description;
    private List<EpisodeResponseDto> episodes;

    public DramaResponseDto(Drama drama, List<EpisodeResponseDto> episodes){
        this.id = drama.getId();
        this.title = drama.getTitle();
        this.thumbnailUrl = drama.getThumbnailUrl();
        this.description = drama.getDescription();
        this.episodes = episodes;
    }
}
