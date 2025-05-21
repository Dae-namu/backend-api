package com.daenamu.episode.repository;

import com.daenamu.episode.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findByDramaId(Long dramaId);
}
