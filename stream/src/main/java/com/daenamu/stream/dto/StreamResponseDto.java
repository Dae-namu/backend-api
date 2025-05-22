package com.daenamu.stream.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StreamResponseDto {

    private Long episodeId;
    private String streamUrl;
}
