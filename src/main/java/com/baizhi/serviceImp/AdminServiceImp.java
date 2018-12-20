package com.baizhi.serviceImp;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImp implements AdminService {
    @Resource
    AdminMapper adminMapper;


    @Override
    public Admin getOne(String name, String password) {
        return adminMapper.queryOne(name, password);
    }
}
