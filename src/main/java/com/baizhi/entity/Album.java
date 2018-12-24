package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
@ExcelTarget("album")
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name = "编号",needMerge = true)
    private Integer id;
    @Excel(name = "专辑名称",needMerge = true)
    private String title;
    private Integer count;
    @Excel(name = "图片",needMerge = true,type = 2)
    private String coverImg;
    private Double score;
    @Excel(name = "作者",needMerge = true)
    private String author;
    private String broadcast;
    private String brief;
    @Excel(name="日期", format = "yyyy-MM-dd",height = 20, width = 30,needMerge = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date publishDate;
    @ExcelCollection(name="章节")
    @Transient
    private List<Chapter> children;
}
