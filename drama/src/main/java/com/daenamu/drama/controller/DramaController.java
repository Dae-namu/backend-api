package com.daenamu.drama.controller;

import com.daenamu.drama.dto.DramaResponseDto;
import com.daenamu.drama.service.DramaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dramas")
public class DramaController {

    private final DramaService dramaService;

    @GetMapping
    public List<DramaResponseDto> getAllDramas(){
        return dramaService.getAllDramas();
    }
}
