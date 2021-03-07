package com.jslhrd.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("test09")											//model 매개변수 전달	
	public void test09(Model model , @RequestParam("page") int page ) {// requestparam 매개변수를 받기위해 
				    	// ^   == Model model = new model();

		log.info("test09() call..... " );
		log.info("page= "+page );
		
		//jsp 엿으면 void > retrun list
		List<String> list = new ArrayList<>();
		list.add("kim");
		list.add("park");
		list.add("kimura");
		list.add("suzuki");
		
		model.addAttribute("list", list);// test09로 list전달
		
	}
	
	//java bean file (vo,dto) >> 자동 전달자 역할
	@RequestMapping("test10")	
	public void test10(SampleVO vo ,Model model, @RequestParam("page") int page ) {
		log.info("test10() call..... " );
		
		log.info("SampleVO:"+vo);
		log.info("page:"+page);
		
		model.addAttribute("vo",vo);
	}
	
	@RequestMapping("test11")	
	public void test11(SampleVO vo , @ModelAttribute("page") int page ) {
						//^자체가 전달자    //^requestparam은 전달되지 않아서 modelattribute사
		log.info("test11() call..... " );
		log.info("SampleVO:"+vo);
		log.info("page:"+page);
	}
	
	//일회성 전달 RedurectAttributes
	@RequestMapping("test12")//>>mapping info
	public String test12( RedirectAttributes rttr ) {
		log.info("test12() Call.... ");
		
		rttr.addFlashAttribute("row",1);
		return "redirect:/sample/test12_pro"; //1회성
	}
	
	@GetMapping("test12_pro") //get 전용 mapping
	public void test12_pro() {}
	
	@RequestMapping("test13")//
	public String test13() { //>> void  test13에 가지만 string 이면 경로를 찾아감
		log.info("test13() Call.... ");
		// 13을 호출
		return "/sample/test13_pro"; // >>그냥경로지만  jsp file 이있으면 jsp파일이ㅣㅁ
	}
	
	@GetMapping("test13_pro") //get 전용 mapping
	public void test13_pro() {}
	
	
	//리턴타임 객체 vo,dto
	// json type 만들때 사용 javascript object nation 
	// 속성 -값 쌍으로 구성된 데이터 ajax,xml에서 사용
	@GetMapping("test14")//
	public @ResponseBody SampleVO test14() { //>> void  test13에 가지만 string 이면 경로를 찾아감
		log.info("test14() Call.... ");
		SampleVO vo = new SampleVO();
		vo.setName("gildong");
		vo.setAge(20);
		vo.setTel("010-1111-1111");
		
		return vo;
	
	}
	
	
	
	
	
	
}












