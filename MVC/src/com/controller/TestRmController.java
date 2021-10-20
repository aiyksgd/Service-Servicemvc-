package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 注解的方式使用
 * @author Administrator
 * 
 * 如果是在类上面配置的  @RequestMapping 直接访问路径,如果类中有一个方法,则一定会执行那个方法
 * 如果指定的了请求方式就会匹配得上的方法执行
 * 
 * params: 是用来指定url上面必需要带的参数标识  同时也有逻辑功能
 *   
 */
@Controller // 表示这个是一个Controller
@RequestMapping("/testrm")
public class TestRmController {
	
	// 5 @RequestMapping 里面的一些写法
	@RequestMapping(params="method=a",method=RequestMethod.POST) //请求此方法一定要是post方式
	public String a(Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解  params");
		return "resu"; //视图的名称
	}


	@RequestMapping(params="method=b",method=RequestMethod.GET) //请求此方法一定要是get方式
	public String b(Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解  params  b");
		return "resu"; //视图的名称
	}


	@RequestMapping(params="cc",method=RequestMethod.GET) //请求此方法一定要是get方式
	public String c(Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解  params  c");
		return "resu"; //视图的名称
	}
	
	@RequestMapping(value="/d",params="dd") //请求此方法get和post都可以
	public String d(Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解  params  d");
		return "resu"; //视图的名称
	}
	
	//http://localhost:8080/springmvct/testrm/f?dd&f
	@RequestMapping(value="/f",params= {"dd","f"}) //请求此方法get和post都可以
	public String f(Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解  params  d");
		return "resu"; //视图的名称
	}
	
	//http://localhost:8080/springmvct/testrm/g?dd&a=9
	//http://localhost:8080/springmvct/testrm/g?dd&a!=10    
	//http://localhost:8080/springmvct/testrm/g?dd&a=10 不行  下从v吧/呕8	@RequestMapping(value="/g",params= {"dd","a!=10"}) //请求此方法get和post都可以
	public String g(Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解  params  d");
		return "resu"; //视图的名称
	}
	
	// Restful风格和@PathVariable
	@RequestMapping("/del/{id}") 
	public String del(@PathVariable Integer id,ModelMap modelMap){
		System.out.println(id);
		//将数据显示到页面
		modelMap.addAttribute("msg","Restful风格和@PathVariable ="+id);
		return "resu";
	}


	
}