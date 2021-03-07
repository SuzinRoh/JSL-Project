package com.jslhrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.service.BoardService;

import lombok.Setter;

@Controller
@RequestMapping("Board")
public class BoardController {
	private static final Logger log=
			LoggerFactory.getLogger(BoardController.class);
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
	//게시물 전체 목록(board_list.jsp)
	@RequestMapping("board_list")
	public void boardList(Model model) {
		log.info("BoardController : boardList() . . . . ");
		model.addAttribute("count",service.boardCount());
		model.addAttribute("list",service.boardList());
		
	}
	//글쓰기 폼으로 이동
	@RequestMapping("board_write")
	public void boardWrite() {
		log.info("BoardController : boardWrite() . . . . ");
	}
	//등록처리
	@PostMapping("board_write")//매핑정보가 똑같을 string
	public String boardWritePro(BoardVO vo, RedirectAttributes rttr) {
		log.info("BoardController : boardWritePro() . . . . ");
		int row = service.boardWrite(vo);
		rttr.addFlashAttribute("row",row);
		
		return "redirect:/Board/board_write_pro";
	}
	@GetMapping("board_write_pro")
	public void BoardWriteResult() {
		log.info("BoardController : boardWriteResult() . . . . ");
	}
	
	//뷰페이지 이동
	@GetMapping("board_view")
	public void boardView(Model model , @RequestParam("idx") int idx) {
		log.info("BoardController : boardView() . . . . ");
		service.boardHits(idx);
		BoardVO vo =service.boardSelect(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		model.addAttribute("board", vo); // == model.addAttribute("board",service.boardSelect(idx));
	}
	
	//수정폼
	@GetMapping("board_modify")
	public void boardModify(Model model, @RequestParam("idx") int idx) {
		log.info("BoardController : boardModify() . . . . ");
		
		BoardVO vo = service.boardSelect(idx);
		model.addAttribute("board",vo);
	}
	//수정처리
	@PostMapping("board_modify")
	public String boardModifyPro(BoardVO vo, Model model) {
		log.info("BoardController : boardModifyPro() . . . . ");
		
		int row = service.boardUpdate(vo);
		log.info(vo.getContents());
		log.info(vo.getSubject());
		log.info(vo.getPass());
		log.info("" + vo.getIdx());
		log.info("BoardController : " + row);
		model.addAttribute("row" , row);
		return "/Board/board_modify_pro"; //not redirect, just return 
	}
	
}
