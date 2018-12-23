package com.baizhi.serviceImp;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.ChapterService;
import com.baizhi.util.GetMp3TrackLength;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
   @Resource
    ChapterMapper chapterMapper;

    @Override
    public void insertChapter(Chapter chapter, HttpSession session, MultipartFile file) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String s1 = servletContext.getRealPath("/music");
        String s2 = s1 + "\\" + file.getOriginalFilename();
        File file1 = new File(s2);
        file.transferTo(file1);
        String sizeFormat = new DecimalFormat("0.00").format((double) file.getSize() / 1024 / 1024);
        chapter.setSize(sizeFormat+"MB");
        chapter.setUrl(s2);
        chapter.setAlbum_id(chapter.getAlbum_id());
        chapter.setDuration(chapter.getDuration());
        chapter.setId(UUID.randomUUID().toString().replace("-",""));
        GetMp3TrackLength gtl = new GetMp3TrackLength();
        int mp3TrackLength = gtl.getMp3TrackLength(file1);
        double v = (double) mp3TrackLength / 60;
        if(v>1){
            String timeformat = new DecimalFormat("0.00").format(v);
            chapter.setSize(timeformat+"分钟");
        }else{
            double v1 = v * 60;
            String timeformat = new DecimalFormat("0.00").format(v1);
            chapter.setSize(timeformat+"秒");
        }
        chapterMapper.insertSelective(chapter);
    }


}

