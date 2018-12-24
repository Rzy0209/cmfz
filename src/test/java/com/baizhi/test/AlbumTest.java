package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class AlbumTest {
    @Resource
    AlbumMapper albumMapper;

    @Test
    public void Test1(){
        List<Album> list = albumMapper.selectAll();
        System.out.println(list);
    }
}
