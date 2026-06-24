package com.tonemirror.entity.files;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "generated_file_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedFileLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

//    FK 설정 X. 파이썬 서버에 파라미터로 보내준 것 기준 조회용이고,
//    row 생성은 파이썬 서버에서 이루어질 것이기 때문에
//    복잡하게 ManyToOne, 외래키 설정하지 않음
    @Column(name = "parent_file_id", nullable = false)
    private Long parentFileId;

    @Column(name = "file_url", length = 1000, nullable = false)
    private String fileUrl;

    @Column(name = "file_type", length = 20, nullable = false)
    private String fileType;

    @Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void softDelete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now();
    }
}
