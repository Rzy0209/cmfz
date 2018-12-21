package com.baizhi.controller;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/banner")
@Log4j
public class BannerController {
    @Resource
    BannerService bannerService;

    /**
     *
     查所有功能
     */
    @ResponseBody
    @RequestMapping("showAll")
    public List<Banner> showAll(){
       return bannerService.queryAll();
    }

    /**
     *
     更新功能
     */
    @RequestMapping("updateBanner")
    @ResponseBody
    public void updateBanner(Banner banner){
        bannerService.updateBanner(banner);
    }

    /**
     *
     删除功能
     */
    @ResponseBody
    @RequestMapping("deleteBanner")
    public String deleteBanner(Banner banner){
        bannerService.deleteBanner(banner);
        return "";
    }
    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping("showByPage")
    public BannerDto  showByPage(Integer page,Integer rows){
      return bannerService.queryByPage(page, rows);
    }

    /**
     * 添加Banner
     */
    @ResponseBody
    @RequestMapping("addBanner")
    public void addBanner(Banner banner, HttpSession session, MultipartFile file) throws IOException {
        bannerService.addBanner(banner,session,file);
    }
}
