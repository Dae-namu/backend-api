package com.daenamu.stream.service;

import com.daenamu.stream.dto.StreamResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

    public StreamResponseDto getStreamByEpisodeId(Long episodeId){
        String url = "https://daenamu-test.s3.ap-northeast-2.amazonaws.com/episode-" + episodeId + ".mp4";
        return new StreamResponseDto(episodeId, url);
    }
}
