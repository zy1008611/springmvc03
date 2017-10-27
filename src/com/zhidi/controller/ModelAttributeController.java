package com.zhidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhidi.entity.Student;

@Controller
@RequestMapping("/model")
public class ModelAttributeController {
	//模型比处理方法先执行，意味着模型中的参数可以传入方法中当做参数，多个模型时，模型之间时无序执行的
	//当处理方法中的形参与模型中的不一致时，当处理方法上的参数与模型的参数一致时，相当于在处理方法中改变了模型中相对应的值
	@ModelAttribute("stu")
	public Student testAttribute(){
		Student stu =new Student();
		stu.setName("王五");
		stu.setSex(3);
		stu.setId(2);
		System.out.println(stu);
		return stu;
	}
	
	@RequestMapping("/edit")
	public String testModel(@ModelAttribute("stu") Student stu1){
		stu1.setName("李四");
		System.out.println(stu1);
		return "edit";
	}
}
