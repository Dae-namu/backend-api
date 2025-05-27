package com.daenamu.drama.feign;

import com.daenamu.drama.dto.EpisodeResponseDto;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "episode", configuration = FeignTracingConfig.class)
public interface EpisodeClient {

    @GetMapping("/episodes/drama/{dramaId}")
    public List<EpisodeResponseDto> getEpisodesByDramaId(@PathVariable("dramaId") Long dramaId);

    @GetMapping("/episodes/{id}")
    public EpisodeResponseDto getEpisodeById(@PathVariable("id") Long id);
}
