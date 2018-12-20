package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/banner")
@Log4j
public class BannerController {
    @Resource
    BannerService bannerService;

    @ResponseBody
    @RequestMapping("showAll")
    public List<Banner> showAll(){
       return bannerService.queryAll();
    }

    @RequestMapping("updateBanner")
    @ResponseBody
    public void updateBanner(Banner banner){
        bannerService.updateBanner(banner);
    }

    @ResponseBody
    @RequestMapping("deleteBanner")
    public String deleteBanner(Banner banner){
        bannerService.deleteBanner(banner);
        return "";
    }
}
