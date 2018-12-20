package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    public Admin getOne(String name, String password);
}
