package com.baizhi.service;

import com.baizhi.entity.Province;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    /**
     * @return  返回最近一周注册人数
     */
    Integer getOneWeek();
    Integer getTwoWeek();
    Integer getThreeWeek();
    List<Province> getProvince();
}
