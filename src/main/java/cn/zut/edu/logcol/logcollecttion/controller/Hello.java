package cn.zut.edu.logcol.logcollecttion.controller;


import org.springframework.web.bind.annotation.*;

@RestController

public class Hello {
    @GetMapping("/hello/{id}")
    public String hello(@PathVariable Long id){
        return "hello"+id;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
