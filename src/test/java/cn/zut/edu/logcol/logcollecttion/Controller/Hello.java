package cn.zut.edu.logcol.logcollecttion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class Hello {
    @RequestMapping("/index")
    public String hello(){
        return "hello";
    }
}
