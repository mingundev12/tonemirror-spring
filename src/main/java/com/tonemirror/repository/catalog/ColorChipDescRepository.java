package com.tonemirror.repository.catalog;

import com.tonemirror.entity.catalog.ColorChipDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorChipDescRepository extends JpaRepository<ColorChipDesc, Long> {
}
