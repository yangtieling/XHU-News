package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.xhu.pojo.GraphBar;
import com.xhu.service.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/index")
@Controller
public class IndexController {
    @Autowired
    private NewsDetailService newsDetailService;

    @ResponseBody
    @RequestMapping(value = "findGraphBarData", produces = "application/json;charset=utf-8")
    public String findGraphBarData() {
        List<GraphBar> list = newsDetailService.findGraphBarData();
        String result = JSON.toJSONString(list);
        return result;
    }
}
