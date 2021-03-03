package com.jslhrd.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import con.jslhrd.domain.SampleVO;

@Controller //어노테이션을 붙이는 순간 컨트롤러로 인식해줌
@RequestMapping("sample") //기본경로jsp랑 똑같음 > path?

public class SampleController {
	private static final Logger log =
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("")
	public void test01() {
		log.info("test01() call ....... ");
	}
	@RequestMapping("test02")
	public void test02() {
		log.info("test02() call ....... ");
	}
	@RequestMapping("test03")//parameter 받을떄
	public void test03(@RequestParam("name") String name,@RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
	}
	
	@RequestMapping("test04")//parameter 받을떄
	public void test04(String name,int age) {
		log.info("name : " + name);
		log.info("age : " + age);
	}

	@RequestMapping("test05")//parameter 받을떄
	public void test05(SampleVO vo) {
		log.info("SampleVO : " + vo);
	}
	
	@RequestMapping("test06")//parameter 받을떄
	public void test06(String[] ids) {
		log.info("String[] ids : " + Arrays.toString(ids));
	}
	
	@RequestMapping("test07")//parameter 받을떄
	public void test07(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ArrayList ids : " + ids);
	}

	@RequestMapping("test08")//parameter 받을떄
	public void test08(Model model) {//model 전달자
		log.info("test08() call..... " );
		model.addAttribute("row",100);
		model.addAttribute("name","gildong");//model 전달자
	}
}
