package com.daenamu.episode.feign;

import com.daenamu.episode.dto.StreamResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stream-service", url = "http://localhost:8003")
public interface StreamClient {

    @GetMapping("/streams/drama/{dramaId}/episode/{episodeId}")
    StreamResponseDto getStreamByEpisodeId(
            @PathVariable("dramaId") Long dramaId,
            @PathVariable("episodeId") Long episodeId);
}
