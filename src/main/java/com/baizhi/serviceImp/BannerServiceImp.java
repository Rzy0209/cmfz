package com.baizhi.serviceImp;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
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

    @Override
    public BannerDto queryByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        BannerDto dto = new BannerDto();
        List<Banner> list = bannerMapper.selectAll();
        int count = bannerMapper.selectCount(new Banner());
        dto.setRows(list);
        dto.setTotal(count);
        return dto;
    }


    @Override
    public void addBanner(Banner banner, HttpSession session, MultipartFile file)throws IOException {

        ServletContext scc = session.getServletContext();
        String s1 = scc.getRealPath("/image");
        String s2 = s1 + "\\" + file.getOriginalFilename();
        File file1 = new File(s2);
        file.transferTo(file1);
        banner.setImgPath("/image/"+file.getOriginalFilename());
        bannerMapper.insert(banner);
    }
}
