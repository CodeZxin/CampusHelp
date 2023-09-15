package njust.service;

import jakarta.servlet.http.HttpServletRequest;
import njust.mapper.UserMapper;
import njust.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean login(String stuNumber, String password, HttpServletRequest req) {
        User user = userMapper.selectUser(stuNumber);
        if (user == null) req.setAttribute("msg", "登录失败--账号不存在");
        else if (!password.equals(user.getPassword())) req.setAttribute("msg", "登录失败--密码不正确");
        else {
            req.getSession().setAttribute("nowuser", user);
            return true;
        }
        return false;
    }

    public boolean register(User newUser) {
        User user = userMapper.selectUser(newUser.getStuNumber());
        if (user != null) return false;
        return userMapper.insertUser(newUser) > 0;
    }
}
