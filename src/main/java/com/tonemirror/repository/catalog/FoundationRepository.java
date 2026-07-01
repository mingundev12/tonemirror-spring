package com.tonemirror.repository.catalog;

import com.tonemirror.entity.catalog.Foundation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundationRepository extends JpaRepository<Foundation, Long> {
}
