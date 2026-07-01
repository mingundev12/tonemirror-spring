package com.tonemirror.repository.catalog;

import com.tonemirror.entity.catalog.FoundationDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundationDescRepository extends JpaRepository<FoundationDesc, Long> {
}
