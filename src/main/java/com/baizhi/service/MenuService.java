package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    //一级类别
    public List<Menu> queryAll();

    //二级类别
    public List<Menu> queryAll(Integer id);
}
