package njust.controller;

import jakarta.servlet.http.HttpServletRequest;
import njust.pojo.User;
import njust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(String stuNumber, String password, HttpServletRequest req){
        boolean ok = userService.login(stuNumber, password, req);
        if(ok)return "redirect:/allTask/5/1";
        else return "forward:/login.jsp";
    }

    @RequestMapping("register")
    public String register(User user){
        boolean ok = userService.register(user);
        if(ok)return "login";
        else return "register";
    }
}
