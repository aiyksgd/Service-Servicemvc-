package com.mvc;




import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




/**
 * 注解的方式使用
 * @author Administrator·
 *
 */
@Controller // 表示这个是一个Controller
public class MvcCooii {
	
	@RequestMapping("/test") // 请求此方法
	public String test(Model model) { // Map  ModelAndView Model  List User Integer String 
		model.addAttribute("msg", "Hello World!");
		return "Dir/test"; // 视图的名称
	}


	@RequestMapping("/test2") // 请求此方法
	public ModelAndView list2(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// ModelAndView是封装要显示到页面的数据
		ModelAndView mv = new ModelAndView();
		// 页面的数据
		mv.addObject("msg", "Hello World!  ");
		// 配置视图的名称
		mv.setViewName("Dir/test2");
		return mv;
	}
	
	    // servlet api 的使用     写内容给请求方   ( 这样的写法,其实就是servlet, 这样的写法是用来做接口的
		// 常景: 我方请求别的项目或接口,希望获取一些数据,别人就应该这样写.
		//  或 我方需要提供数据给别,我就要这样写 )    返回json格式. 
		@RequestMapping("/res") // 请求此方法
		public void fow(HttpServletRequest request, HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("spring mvc 中用 servlet api ");
		}
		
		//forward: 转发, 这样写不会走spring mvc 的视图渲染器 所以需要带上后缀名,
		@RequestMapping("/zhuanfa") 
		public String zhuanfa(HttpServletRequest request, HttpServletResponse response) throws Exception{
			//这个方法里面的request 和response 参数是可以写也可以不写的 .
			// 如果要用就写,不要用就不写 ,要用哪个就写哪个.
			request.setAttribute("name", "张三");
			return "forward:zhanfax.jsp?tel=13458454544";  //转发 地址栏不变  到webcontent
			//return "redirect:zhuanxiang.jsp"; //转向 地址栏变
		}
		
		//redirect: 转向, 和转发相同  
		@RequestMapping("/zhuanxiang") 
		public String zhuanxiang() throws Exception{
			// 有中文必需要转码    ( 到拿得地方解码   转 用URLEncoder.encode 解用URLDecoder.decode)
			return "redirect:zhuanxiang.jsp?addr="+URLEncoder.encode("深圳","utf-8"); //转向 地址栏变
		}
	
		
}