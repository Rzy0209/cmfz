package com.baizhi.serviceImp;

import com.baizhi.entity.Menu;
import com.baizhi.mapper.MenuMapper;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImp implements MenuService {
    @Resource
    MenuMapper menuMapper;


    @Override
    public List<Menu> queryAll() {
        Example example = new Example(Menu.class);
        example.createCriteria().andIsNull("parentId");
        List<Menu> list = menuMapper.selectByExample(example);
        if (list == null) {
            throw new RuntimeException("数据为空");
        } else {
            return list;
        }
    }

    @Override
    public List<Menu> queryAll(Integer id) {
        Menu m = new Menu();
        m.setParentId(id);
        List<Menu> list = menuMapper.select(m);
        for (Menu menu : list) {
            menu.setText(menu.getTitle());
        }
        return list;
    }
}
