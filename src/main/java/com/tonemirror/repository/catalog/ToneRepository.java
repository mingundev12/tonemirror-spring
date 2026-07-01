package com.tonemirror.repository.catalog;

import com.tonemirror.entity.catalog.Tone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToneRepository extends JpaRepository<Tone, Long> {
}
