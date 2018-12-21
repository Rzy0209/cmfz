package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public interface BannerService {
     List<Banner > queryAll();
     void updateBanner(Banner banner);
     void deleteBanner(Banner banner);
     BannerDto queryByPage(Integer page, Integer rows);
     void addBanner(Banner banner,HttpSession session, MultipartFile file) throws IOException;


}
