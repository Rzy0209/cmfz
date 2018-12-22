package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/album")
@Log4j
public class AlbumController  {
    @Resource
    AlbumService albumService;


    @ResponseBody
    @RequestMapping("showAll")
    public List<Album> showAll(){
        return albumService.getAll();
    }
}
