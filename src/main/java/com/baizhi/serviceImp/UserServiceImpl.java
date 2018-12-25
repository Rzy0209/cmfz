package com.baizhi.serviceImp;

import com.baizhi.entity.Province;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl  implements UserService {
    @Resource
    UserMapper userMapper;

    /**
       获取最近一周的活跃人数
     */
    @Override
    public Integer getOneWeek() {
        return userMapper.getOneWeek();
    }

    @Override
    public Integer getTwoWeek() {
        return userMapper.getTwoWeek();
    }

    @Override
    public Integer getThreeWeek() {
        return userMapper.getThreeWeek();
    }

    @Override
    public List<Province> getProvince() {
        return userMapper.getProvince();
    }


}
