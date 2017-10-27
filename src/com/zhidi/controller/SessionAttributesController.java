package com.zhidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.zhidi.entity.User;

@Controller
@RequestMapping("/session")
@SessionAttributes("user")
public class SessionAttributesController {
	
	@RequestMapping("/login")
	public String login(Model model,User user){
		model.addAttribute("user", user);
		if(user!=null && "asd".equals(user.getName()) && "234".equals(user.getPassword())){
			System.out.println("登录成功");
			//密码成功，跳转成功页面
			return "success";
		}
		System.out.println("登录失败");
		//密码验证失败，跳转登录页面
		return "forward:/login.jsp";
	}
	//修改密码
	@RequestMapping("/update")
	public String updatepw(@ModelAttribute("user") User user){
		user.setPassword("666");
		return "success";
	}
	//清空session中的值
	@RequestMapping("/lgout")
	public String tosuccess(SessionStatus status){
		//清空session中的数据
		status.setComplete();
		return "success";
	}
	@RequestMapping("/tosuccess")
	public String success(){
		return "success";
	}
	
	
}
