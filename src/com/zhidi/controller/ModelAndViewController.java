package com.zhidi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 除了返回String 和ModelAndView可以设置返回视图，返回其他的pojo(如：Student，Map，Model[接口]，ModelMap等)都不能设置返回的视图，返回的视图为：前缀+url地址+后缀
 * 页面上的el表达式，只适用于带有键值对应的集合。如Map,ModelMap ,等，其中list不属于该类中
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class ModelAndViewController {
	
	@RequestMapping("/index")
	public String testindex(){
		return "index";
	}
	//jsp那边相当于req请求接收
	@RequestMapping("/model")
	public ModelAndView testModel(ModelAndView mv){
		mv.addObject("name", "小子");
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/modelview")
	public ModelMap testmodelmap(ModelMap modelMap){
		modelMap.addAttribute("name", "靠靠卡卡卡");
		modelMap.addAttribute("sex", 1);
		return modelMap;
	}
	//对面的jsp相当于用request接收
	@RequestMapping("/map")
	public Map<String, Object> testmap(){
		Map<String, Object> map =new HashMap<>();
		map.put("name", "李四");
		return map;
	}
	//使用forward转发时，不加"/"代表本请求的相对路径请求，加上"/"代表绝对路径
	//绝对路径测试  转发
	@RequestMapping("/forward")
	public String testForword(){
		
		return "forward:/admin2/index2.do";
	}
	//重定向
	@RequestMapping("/redirect")
	public String testredirect(){
		return "redirect:/admin2/index2.do";
	}
	//相对路径 forward 路径不变
	@RequestMapping("/forward1")
	public String testforward1(){
		
		return "forward:index.do";
	}
	//redirect 路径改变（重定向后的页面路径）其中("/redirect1") 的"/"没什么意义，建议加上
	@RequestMapping("/redirect1")
	public String testredirect1(){
		
		return "redirect:redirect.do";
	}
	
	
}	
