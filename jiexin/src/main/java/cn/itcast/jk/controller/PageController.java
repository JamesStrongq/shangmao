package cn.itcast.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/index")
    public String pageIndex(){
        return "index";

    }

    @RequestMapping("/login")
    public String pageLogin(){
        return "/home/fmain";
    }

    @RequestMapping("/title")
    public String pageTitle(){
        return "/home/title";
    }

    @RequestMapping("/cargoLeft")
    public String pageLeft(){

        return "/home/left";
    }

    @RequestMapping("/cargoMain")
    public String pageMain(){
        return "/home/olmsgList";
    }

    @RequestMapping("/baseinfoMain")
    public String pageBaseInfoMain(){
        return "/baseinfo/main";
    }

    @RequestMapping("/baseinfoLeft")
    public String pageBaseInfoLeft(){
        return "/baseinfo/left";
    }
}
