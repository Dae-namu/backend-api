package com.daenamu.stream.controller;

import com.daenamu.stream.dto.StreamResponseDto;
import com.daenamu.stream.service.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/streams")
public class StreamController {

    private final StreamService streamService;

    @GetMapping("/episode/{episodeId}")
    public StreamResponseDto getStreamByEpisodeId(@PathVariable("episodeId") Long episodeId){
        return streamService.getStreamByEpisodeId(episodeId);
    }
}
