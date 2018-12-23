package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService  {
    /**
      查所有专辑及其下边的章节
     */
    List<Album> getAll();
    /**
     * 通过id 获取专辑对象
     */
    Album getOne(Integer id);

    /**
     * 添加专辑
     */
    void insertAlbum(Album album);
}
