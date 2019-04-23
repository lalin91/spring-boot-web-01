package cn.lalin.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lalin
 * @date 2019/4/23 - 12:51
 */
@Controller
public class LoginController {

    @PostMapping(value="/user/login")
//    @RequestMapping(value="/user/login",method= RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "336699".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
