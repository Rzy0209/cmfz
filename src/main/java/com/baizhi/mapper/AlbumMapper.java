package com.baizhi.mapper;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    /**
     *查所有专辑对应的章节
     */
     List<Album> queryAll();


}
