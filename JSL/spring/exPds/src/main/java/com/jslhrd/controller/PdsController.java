package com.jslhrd.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jslhrd.domain.PdsVO;
import com.jslhrd.service.PdsService;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Controller
@AllArgsConstructor
@RequestMapping("Pds")
public class PdsController {
	private static final Logger log = 
            LoggerFactory.getLogger(PdsController.class);

	@Setter(onMethod_=@Autowired)
	private PdsService service;
	
	@GetMapping("pds_count")
	public void pdsCount() {
		log.info("Controller pdsCount : " + service.pdsCount());
	}
	
	@GetMapping("pds_list")
	public void pdsList(Model model) {
		log.info("Controller pdsList : ");
		model.addAttribute("totcount", service.pdsCount());
		model.addAttribute("list", service.pdsList());
	}
	// 글등록 폼
	@GetMapping("pds_write")
	public void pdsWrite() {
		log.info("Controller pdsWrite : ");
	}
	/*
	// 등록 처리
	@PostMapping("pds_write")
	public String pdsWritePro(MultipartHttpServletRequest request) {
		log.info("Controller pdsWritePro : ");
		PdsVO vo = new PdsVO();
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		MultipartFile mf = request.getFile("filename");
		// 업로드 경로 설정
		String path=request.getRealPath("/resources/upload/");
		String fileName=mf.getOriginalFilename();
		File file=new File(path+fileName);
		try {
			mf.transferTo(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		vo.setFilename(fileName);
		service.pdsWrite(vo);
		return "redirect:/Pds/pds_list";// 매핑정보
	}*/
	
	// 등록 처리
	@PostMapping("pds_write")
	public String pdsWritePro(MultipartHttpServletRequest request) {
		log.info("Controller pdsWritePro : ");
		PdsVO vo = new PdsVO();
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		MultipartFile mf = request.getFile("filename");
		// 업로드 경로 설정
		String path=request.getRealPath("/resources/upload/");
		String fileName=mf.getOriginalFilename();
		File file=new File(path+fileName);
		try {
			mf.transferTo(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		vo.setFilename(fileName);
		service.pdsWrite(vo);
		return "redirect:/Pds/pds_list";// 매핑정보
	}
	/*
	//view
	@GetMapping("pds_view")
	public void pdsView(@RequestParam("idx") int idx, Model model) {
		log.info("Controller pdsView : ");
		service.pdsHits(idx);
		PdsVO pds =  service.pdsSelect(idx);
		pds.setContents(pds.getContents().replace("\n", "<br>"));
		model.addAttribute("pds", );
	}
	
	//view cookie 처
	@GetMapping("pds_view")
	public void pdsView(@RequestParam("idx") int idx, Model model,HttpServletRequest request, HttpServletResponse response) {
		log.info("Controller pdsView : ");
		service.pdsHits(idx);
		
		boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i< cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("pdsCookie"+idx)) {
				found =true;
				break;
			}
		}
		String str ="" + System.currentTimeMillis();
		if(!found) {
			info = new Cookie("PdsCookies" + idx, str);
			response.addCookie(info);
			service.pdsHits(idx);
		}
		
		PdsVO pds =  service.pdsSelect(idx);
		pds.setContents(pds.getContents().replace("\n", "<br>"));
		model.addAttribute("pds", pds);
	}*/
	//create pds cookie 
	@GetMapping("Pds_hits")
	public String pdsHits(@RequestParam("idx") int idx, Model model,HttpServletRequest request, HttpServletResponse response) {
		log.info("Controller pdsView : ");
		
		boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i< cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("pdsCookie"+idx)) {
				found =true;
				break;
			}
		}
		String str ="" + System.currentTimeMillis();
		if(!found) {
			info = new Cookie("PdsCookies" + idx, str);
			response.addCookie(info);
			service.pdsHits(idx);
		}
		return "redirect:pds_view?idx="+idx;
	}
	
	//view
	@GetMapping("pds_view")
	public void pdsView(@RequestParam("idx") int idx, Model model) {
		log.info("Controller pdsView : ");
		PdsVO pds =  service.pdsSelect(idx);
		pds.setContents(pds.getContents().replace("\n", "<br>"));
		model.addAttribute("pds", pds);
	}
	
	//modify form
	@GetMapping("pds_modify")
	public void pdsModift(@RequestParam("idx") int idx, Model model) {
		log.info("Controller pdsModify: ");
		
		model.addAttribute("pds", service.pdsSelect(idx));
	}
	
	//수정처리
		@PostMapping("pds_modify")
		public String pdsModifyPro(MultipartHttpServletRequest request) {
			log.info("Controller pdsModifyPro : ");
			PdsVO vo = new PdsVO();
			vo.setIdx(Integer.parseInt(request.getParameter("idx")));
			vo.setName(request.getParameter("name"));
			vo.setPass(request.getParameter("pass"));
			vo.setEmail(request.getParameter("email"));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			String oldfilename = request.getParameter("oldfilename");
			
			MultipartFile mf = request.getFile("filename");
			// 업로드 경로 설정
			String path=request.getRealPath("/resources/upload/");
			
			String fileName=mf.getOriginalFilename();
			if(fileName.equals("")) {
				vo.setFilename(oldfilename);
			}else {
				File newFile=new File(path+fileName);
				File oldFile=new File(path+oldfilename);
				try {
					if(oldFile.exists()) {
						oldFile.delete();// 파일삭제
					}
					mf.transferTo(newFile);
				}catch(Exception e) {
					e.printStackTrace();
				}
				vo.setFilename(fileName);
			}
			service.pdsModify(vo);
			return "redirect:/Pds/pds_list";// 매핑정보
		}
	
	//삭제 폼
	@GetMapping("pds_delete")
	public void pdsDelete(@ModelAttribute("idx") int idx ) {//받아서 바로 전송할때 씀 받기,보내기 둘다 ok
		log.info("Controller pdsDelete : ");
	}
	
	//삭제처리
	@PostMapping("pds_delete_pro")
	public void pdsDeletePro(PdsVO vo , Model model, HttpServletRequest reqeust) {
		log.info("Controller pdsDelete pro : ");
		PdsVO pds = service.pdsSelect(vo.getIdx());
		int row =service.pdsDelete(vo);
		if(row == 1 ) {
			if(pds.getFilename() != null ) {
				File file = new File(reqeust.getRealPath("/resource/upload/")+pds.getFilename());
				file.delete();
			}
		}
		model.addAttribute("row" , row);
	}
	
	
	
	
}
