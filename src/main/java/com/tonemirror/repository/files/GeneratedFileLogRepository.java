package com.tonemirror.repository.files;

import com.tonemirror.entity.files.GeneratedFileLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GeneratedFileLogRepository extends JpaRepository<GeneratedFileLog, Long> {
    List<String> findFileUrlByCreatedAtBefore(LocalDateTime targetTime);

    @Modifying(clearAutomatically = true)
    @Query("update GeneratedFileLog g " +
            "set g.isDeleted = true, g.deletedAt = :now " +
            "where g.createdAt < :targetTime")
    long softDeleteByCreatedAtBefore(@Param("targetTime") LocalDateTime targetTime, @Param("now") LocalDateTime now);
}
