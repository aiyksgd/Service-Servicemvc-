package com.mvc;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * ���õķ�ʽʹ��
 * �����implements Controller
 */
public class MccCooii implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//ModelAndView�Ƿ�װҪ��ʾ��ҳ�������
		ModelAndView mv = new ModelAndView();
		//ҳ�������
		mv.addObject("qa","Hello World!");
		//������ͼ(ҳ��)������
		mv.setViewName("list");
		return mv;
	}
}

