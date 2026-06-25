package com.tonemirror.entity.files;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "saved_file_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SavedFileLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "file_url", length = 512)
    private String fileUrl;

    @Column(name = "origin_file_name", nullable = false)
    private String originFileName;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "is_valid", nullable = false)
    private boolean isValid;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "message", length = 1000)
    private String message;

    // todo : 서비스 도메인에 맞춰 생성자 구성할 것
    public SavedFileLog(String originFileName, String fileUrl) {
        this.originFileName = originFileName;
        this.fileUrl = fileUrl;
        this.createdAt = LocalDateTime.now();
        this.isValid = true;
        this.isDeleted = false;
    }

    public void updateValidationError(String errorMessage) {
        this.isValid = false;
        this.message = errorMessage;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void softDelete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now();
    }
}
