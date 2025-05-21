package com.daenamu.drama.dto;

import com.daenamu.drama.entity.Drama;
import lombok.Getter;

@Getter
public class DramaResponseDto {

    private Long id;
    private String title;
    private String thumbnailUrl;
    private String description;

    public DramaResponseDto(Drama drama){
        this.id = drama.getId();
        this.title = drama.getTitle();
        this.thumbnailUrl = drama.getThumbnailUrl();
        this.description = drama.getDescription();
    }
}
