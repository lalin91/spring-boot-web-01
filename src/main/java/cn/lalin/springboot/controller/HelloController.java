package cn.lalin.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author lalin
 * @date 2019/4/21 - 19:05
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "/index";
//    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","hello world");
        return "success";
    }
}

