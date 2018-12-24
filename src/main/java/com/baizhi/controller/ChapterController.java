package com.baizhi.controller;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

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

    @ResponseBody
    @RequestMapping("downLoad")
    public void downLoad( String url,HttpSession session,HttpServletResponse response){
        String realPath = session.getServletContext().getRealPath("/music");
        String filePath = realPath + "/" +url;
        File file = new File(filePath);
        try {
            //response.setHeader("Content-Disposition", "attachment;fileName=" +file.getName()+"=utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            response.setContentType("audio/mpeg");
            FileInputStream in = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();

            byte buffer[] = new byte[1024];         //创建缓冲区
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


