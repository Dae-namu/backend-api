package com.daenamu.stream.service;

import com.daenamu.stream.dto.StreamResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.net.URL;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StreamService {

    private final S3Presigner s3Presigner;
    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public StreamResponseDto getStreamByEpisodeId(Long dramaId, Long episodeId){

        String objectKey = dramaId + "/episode-"+episodeId+".mp4";

        try{
            s3Client.headObject(HeadObjectRequest.builder()
                    .bucket(bucketName).key(objectKey).build());
        }
        catch (S3Exception e){
            if(e.statusCode()==404){
                return new StreamResponseDto(episodeId, null);
            }
            throw e;
        }

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
