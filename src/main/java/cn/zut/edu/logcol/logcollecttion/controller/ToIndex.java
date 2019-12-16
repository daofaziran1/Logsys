package cn.zut.edu.logcol.logcollecttion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToIndex {
    @RequestMapping("/return")
    public String index(){
        return "index.html";
    }
}
