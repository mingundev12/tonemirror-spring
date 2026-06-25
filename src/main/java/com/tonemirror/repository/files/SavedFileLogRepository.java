package com.tonemirror.repository.files;

import com.tonemirror.entity.files.SavedFileLog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SavedFileLogRepository {
    void save(SavedFileLog file);

    List<String> findFileUrlByCreatedAtBefore(LocalDateTime targetTime);

    @Modifying(clearAutomatically = true)
    @Query("update SavedFileLog s " +
            "set s.isDeleted = true, s.deletedAt = :now " +
            "where s.createdAt < :targetTime")
    long softDeleteByCreatedAtBefore(@Param("targetTime") LocalDateTime targetTime, @Param("now") LocalDateTime now);
}
