package com.daenamu.drama.repository;

import com.daenamu.drama.entity.Drama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DramaRepository extends JpaRepository<Drama, Long> {
}
