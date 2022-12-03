package com.example.demo.controller;

import com.example.demo.service.VtduService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {
    String ip;
    @Resource
    VtduService vtduService;
    @GetMapping("/")
    String index()
    {
         ip = vtduService.Lvs();
        System.out.println("申请到流媒体服务器："+ip);
        return "view";
    }
    @GetMapping("/save")
    String save()
    {
        vtduService.Save(ip,"1");
        vtduService.Save(ip,"2");
        int count=  vtduService.Save(ip,"3");
        System.out.println("流媒体服务器"+ip+"内已登录通道："+count);
        return "view";
    }
}
