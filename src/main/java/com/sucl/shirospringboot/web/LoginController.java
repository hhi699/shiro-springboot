package com.sucl.shirospringboot.web;

import com.sucl.shirospringboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping
public class LoginController {

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public void login(User user, ServletRequest request, ServletResponse response) throws IOException, ServletException {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
        //    request.getRequestDispatcher("login.html").forward(request,response);
            e.printStackTrace();
        //    return;
        }
        ((HttpServletResponse)response).sendRedirect("index.html");
    }

    @RequestMapping(value = "/logout")
    public void logout(ServletRequest request, ServletResponse response) throws IOException {
        SecurityUtils.getSubject().logout();
        ((HttpServletResponse)response).sendRedirect("index.html");
    }

    @RequestMapping("/in")
    public String index(){
        return "index";
    }

}
