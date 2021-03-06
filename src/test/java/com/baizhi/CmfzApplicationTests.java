package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Album;
import com.baizhi.entity.Province;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.mapper.UserMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

    @Resource
    AlbumMapper albumMapper;
    @Resource
    ChapterMapper chapterMapper;
    @Resource
    UserMapper userMapper;


    @Test
    public void contextLoads() {
        List<Album> list = albumMapper.selectAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑大全","专辑"),
                Album.class, list);
        try {
            workbook.write(new FileOutputStream(new File("D:/a.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextLoads2() {
        List<Album> list = albumMapper.queryAll();
        for (Album album : list) {
            album.setCoverImg("F:/ideaWorkSpace/later/cmfz/src/main/webapp"+album.getCoverImg());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑大全","专辑"),
                Album.class, list);
        try {
            workbook.write(new FileOutputStream(new File("D:/a.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void Test3(){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<Album> list = ExcelImportUtil.importExcel(
                new File("D:/a.xls"),
                Album.class, params);
        for (Album album : list) {
            System.out.println(album);
        }
    }

    @Test
    public void test4(){
        Integer one = userMapper.getOneWeek();

        System.out.println(one);
    }
    @Test
    public void test5(){
        Integer two = userMapper.getTwoWeek();
        System.out.println(two);
    }
    @Test
    public void test6(){
        Integer three = userMapper.getThreeWeek();
        System.out.println(three);
    }

    @Test
    public void test7(){
        List<Province> province = userMapper.getProvince();
        System.out.println(province);
    }

}

