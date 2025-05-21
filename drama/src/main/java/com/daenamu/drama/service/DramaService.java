package com.daenamu.drama.service;

import com.daenamu.drama.dto.DramaResponseDto;
import com.daenamu.drama.repository.DramaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DramaService {

    private final DramaRepository dramaRepository;

    public List<DramaResponseDto> getAllDramas(){
        return dramaRepository.findAll().stream().map(DramaResponseDto::new).toList();
    }
}
