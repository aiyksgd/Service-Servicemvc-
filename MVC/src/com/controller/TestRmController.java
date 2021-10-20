package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ע��ķ�ʽʹ��
 * @author Administrator
 * 
 * ����������������õ�  @RequestMapping ֱ�ӷ���·��,���������һ������,��һ����ִ���Ǹ�����
 * ���ָ����������ʽ�ͻ�ƥ����ϵķ���ִ��
 * 
 * params: ������ָ��url�������Ҫ���Ĳ�����ʶ  ͬʱҲ���߼�����
 *   
 */
@Controller // ��ʾ�����һ��Controller
@RequestMapping("/testrm")
public class TestRmController {
	
	// 5 @RequestMapping �����һЩд��
	@RequestMapping(params="method=a",method=RequestMethod.POST) //����˷���һ��Ҫ��post��ʽ
	public String a(Model model) {
		model.addAttribute("msg", "Hello World! ���springmvcע��  params");
		return "resu"; //��ͼ������
	}


	@RequestMapping(params="method=b",method=RequestMethod.GET) //����˷���һ��Ҫ��get��ʽ
	public String b(Model model) {
		model.addAttribute("msg", "Hello World! ���springmvcע��  params  b");
		return "resu"; //��ͼ������
	}


	@RequestMapping(params="cc",method=RequestMethod.GET) //����˷���һ��Ҫ��get��ʽ
	public String c(Model model) {
		model.addAttribute("msg", "Hello World! ���springmvcע��  params  c");
		return "resu"; //��ͼ������
	}
	
	@RequestMapping(value="/d",params="dd") //����˷���get��post������
	public String d(Model model) {
		model.addAttribute("msg", "Hello World! ���springmvcע��  params  d");
		return "resu"; //��ͼ������
	}
	
	//http://localhost:8080/springmvct/testrm/f?dd&f
	@RequestMapping(value="/f",params= {"dd","f"}) //����˷���get��post������
	public String f(Model model) {
		model.addAttribute("msg", "Hello World! ���springmvcע��  params  d");
		return "resu"; //��ͼ������
	}
	
	//http://localhost:8080/springmvct/testrm/g?dd&a=9
	//http://localhost:8080/springmvct/testrm/g?dd&a!=10    
	//http://localhost:8080/springmvct/testrm/g?dd&a=10 ����  �´�v��/Ż8	@RequestMapping(value="/g",params= {"dd","a!=10"}) //����˷���get��post������
	public String g(Model model) {
		model.addAttribute("msg", "Hello World! ���springmvcע��  params  d");
		return "resu"; //��ͼ������
	}
	
	// Restful����@PathVariable
	@RequestMapping("/del/{id}") 
	public String del(@PathVariable Integer id,ModelMap modelMap){
		System.out.println(id);
		//��������ʾ��ҳ��
		modelMap.addAttribute("msg","Restful����@PathVariable ="+id);
		return "resu";
	}


	
}