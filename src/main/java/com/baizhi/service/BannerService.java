package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner > queryAll();
    public void updateBanner(Banner banner);
    public void deleteBanner(Banner banner);
}
