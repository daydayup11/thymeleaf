package com.xq.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xq.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }
    //提交表单要用重定向
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        if (user.getUserName().equals("admain")&&user.getPassword().equals("123456")){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        return "main";
    }
}
