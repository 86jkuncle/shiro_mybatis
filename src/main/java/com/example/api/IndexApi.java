package com.example.api;

import com.example.entity.User;
import com.example.vo.ResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @date 2019/9/12 11:08
 */
@Controller
public class IndexApi {
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user",user);
        return "admin/index";
    }

    @GetMapping("/login")
    public String login(){
        return "front/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseVO login(String username,String password,boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            return ResponseVO.error(e.getMessage());
        }catch(IncorrectCredentialsException e){
            return ResponseVO.error(e.getMessage());
        }catch(LockedAccountException e){
            return ResponseVO.error(e.getMessage());
        }catch (Exception e){
            return ResponseVO.error("未知错误");
        }
        return ResponseVO.ok();
    }
}
