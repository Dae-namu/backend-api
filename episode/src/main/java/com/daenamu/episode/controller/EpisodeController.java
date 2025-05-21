package com.daenamu.episode.controller;

import com.daenamu.episode.dto.EpisodeResponseDto;
import com.daenamu.episode.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping("/drama/{dramaId}")
    public List<EpisodeResponseDto> getEpisodesByDramaId(@PathVariable("dramaId") Long dramaId){
        return episodeService.getEpisodesByDramaId(dramaId);
    }

    @GetMapping("/drama/{dramaId}/episode/{episodeId}")
    public EpisodeResponseDto getEpisodeByDramaIdAndEpisodeId(@PathVariable("dramaId") Long dramaId, @PathVariable("episodeId") Long episodeId){
        return episodeService.getEpisodeByDramaIdAndEpisodeId(dramaId, episodeId);
    }
}
