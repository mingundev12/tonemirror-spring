package com.tonemirror.repository.catalog;

import com.tonemirror.entity.catalog.ColorChip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorChipRepository extends JpaRepository<ColorChip, Long> {
}
