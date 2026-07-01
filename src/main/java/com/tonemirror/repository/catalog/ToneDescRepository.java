package com.tonemirror.repository.catalog;

import com.tonemirror.entity.catalog.ToneDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToneDescRepository extends JpaRepository<ToneDesc, Long> {
}
