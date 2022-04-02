package com.xhu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewsComment {
    private Long id;

    private Long newsid;

    private String content;

    private String author;

    private String ip;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")  //页面写入数据库时格式化
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")  //数据库导出页面时json格式化
    private Date createdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewsid() {
        return newsid;
    }

    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}