package com.daenamu.drama.controller;

import com.daenamu.drama.dto.DramaResponseDto;
import com.daenamu.drama.service.DramaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{dramaId}")
    public DramaResponseDto getDramaById(@PathVariable("dramaId") Long dramaId){
        return dramaService.getDramaById(dramaId);
    }
}
