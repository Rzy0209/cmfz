package com.baizhi.serviceImp;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AlbumServiceImpl implements AlbumService {

    @Resource
    AlbumMapper albumMapper;

    /**
     * 查所有分类
     */
    @Override
    public List<Album> getAll() {
        List<Album> list = albumMapper.queryAll();
        if(list!=null){
            return list;
        }else{
            throw new RuntimeException("数据为空，请添加数据");
        }
    }
}
