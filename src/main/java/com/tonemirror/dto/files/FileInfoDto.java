package com.tonemirror.dto.files;

import com.tonemirror.entity.files.SavedFileLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FileInfoDto {
    private Long fileId;
    private String fileUrl;

    public FileInfoDto(SavedFileLog savedFileLog) {
        this.fileId = savedFileLog.getFileId();
        this.fileUrl = savedFileLog.getFileUrl();
    }
}
