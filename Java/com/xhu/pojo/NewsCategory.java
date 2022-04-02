package com.xhu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewsCategory {
    private Long id;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //页面写入数据库格式化
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")  //数据库导出页面格式化
    private Date createdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}