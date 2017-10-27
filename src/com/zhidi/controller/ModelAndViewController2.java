package com.zhidi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Controller
@RequestMapping("/admin2")
public class ModelAndViewController2 {
	
	@RequestMapping("/index2")
	public String testindex(){
		return "edit";
	}
	
	@RequestMapping("/model2")
	public ModelAndView testModel(ModelAndView mv){
		mv.addObject("name", "小子");
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/map2")
	public Map<String, Object> testmap(){
		Map<String, Object> map =new HashMap<>();
		map.put("name", "李四");
		return map;
	}
	@RequestMapping("/forward2")
	public String testForword(){
		
		return "forward:index.do";
	}
}	
