package com.baizhi.controller;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("chapter")
public class ChapterController  {
    @Resource
    ChapterService chapterService;

    @ResponseBody
    @RequestMapping("insertChapter")
    public void insertChapter(Chapter chapter ,HttpSession session, MultipartFile file) throws IOException {
        chapterService.insertChapter(chapter,session,file);
    }


}
