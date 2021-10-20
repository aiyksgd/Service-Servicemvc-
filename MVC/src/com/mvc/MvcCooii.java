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
 * ע��ķ�ʽʹ��
 * @author Administrator��
 *
 */
@Controller // ��ʾ�����һ��Controller
public class MvcCooii {
	
	@RequestMapping("/test") // ����˷���
	public String test(Model model) { // Map  ModelAndView Model  List User Integer String 
		model.addAttribute("msg", "Hello World!");
		return "Dir/test"; // ��ͼ������
	}


	@RequestMapping("/test2") // ����˷���
	public ModelAndView list2(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// ModelAndView�Ƿ�װҪ��ʾ��ҳ�������
		ModelAndView mv = new ModelAndView();
		// ҳ�������
		mv.addObject("msg", "Hello World!  ");
		// ������ͼ������
		mv.setViewName("Dir/test2");
		return mv;
	}
	
	    // servlet api ��ʹ��     д���ݸ�����   ( ������д��,��ʵ����servlet, ������д�����������ӿڵ�
		// ����: �ҷ���������Ŀ��ӿ�,ϣ����ȡһЩ����,���˾�Ӧ������д.
		//  �� �ҷ���Ҫ�ṩ���ݸ���,�Ҿ�Ҫ����д )    ����json��ʽ. 
		@RequestMapping("/res") // ����˷���
		public void fow(HttpServletRequest request, HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("spring mvc ���� servlet api ");
		}
		
		//forward: ת��, ����д������spring mvc ����ͼ��Ⱦ�� ������Ҫ���Ϻ�׺��,
		@RequestMapping("/zhuanfa") 
		public String zhuanfa(HttpServletRequest request, HttpServletResponse response) throws Exception{
			//������������request ��response �����ǿ���дҲ���Բ�д�� .
			// ���Ҫ�þ�д,��Ҫ�þͲ�д ,Ҫ���ĸ���д�ĸ�.
			request.setAttribute("name", "����");
			return "forward:zhanfax.jsp?tel=13458454544";  //ת�� ��ַ������  ��webcontent
			//return "redirect:zhuanxiang.jsp"; //ת�� ��ַ����
		}
		
		//redirect: ת��, ��ת����ͬ  
		@RequestMapping("/zhuanxiang") 
		public String zhuanxiang() throws Exception{
			// �����ı���Ҫת��    ( ���õõط�����   ת ��URLEncoder.encode ����URLDecoder.decode)
			return "redirect:zhuanxiang.jsp?addr="+URLEncoder.encode("����","utf-8"); //ת�� ��ַ����
		}
	
		
}