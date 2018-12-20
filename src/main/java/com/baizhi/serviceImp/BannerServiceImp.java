package com.baizhi.serviceImp;

import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BannerServiceImp implements BannerService {
    @Resource
    BannerMapper bannerMapper;

    @Override
    public List<Banner > queryAll() {
        List<Banner> list = bannerMapper.selectAll();
        if(list!=null) {
            return list;
        }else{
            throw new RuntimeException("数据为空");
        }
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void deleteBanner(Banner banner) {
        bannerMapper.delete(banner);
    }
}
