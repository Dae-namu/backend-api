package com.daenamu.stream.service;

import com.daenamu.stream.dto.StreamResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.net.URL;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StreamService {

    private final S3Presigner s3Presigner;

    public StreamResponseDto getStreamByEpisodeId(Long dramaId, Long episodeId){
        String bucketName = "daenamu-bucket";
        String objectKey = dramaId + "/episode-"+episodeId+".mp4";

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(60))
                .getObjectRequest(getObjectRequest)
                .build();

        URL presignedUrl = s3Presigner.presignGetObject(presignRequest).url();
        return new StreamResponseDto(episodeId, presignedUrl.toString());
    }
}
