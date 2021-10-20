package com.mvc;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * 配置的方式使用
 * 类必需implements Controller
 */
public class MccCooii implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//ModelAndView是封装要显示到页面的数据
		ModelAndView mv = new ModelAndView();
		//页面的数据
		mv.addObject("qa","Hello World!");
		//配置视图(页面)的名称
		mv.setViewName("list");
		return mv;
	}
}

