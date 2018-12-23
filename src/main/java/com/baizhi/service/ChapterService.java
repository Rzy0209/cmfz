package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface ChapterService {
    /**
     * 添加章节
     */
    void insertChapter(Chapter chapter, HttpSession session, MultipartFile file) throws IOException;
}
