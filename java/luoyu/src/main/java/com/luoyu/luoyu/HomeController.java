package com.luoyu.luoyu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangzb
 * @description 首页controllerr
 * @create: 2020-10-11 11:08
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String getHomePage(){
        return "index";
    }
    @RequestMapping("/home")
    public String getHomePage2(){
        return "home";
    }
}
