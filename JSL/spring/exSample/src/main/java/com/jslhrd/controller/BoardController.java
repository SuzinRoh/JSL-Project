package com.jslhrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslhrd.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Controller
@AllArgsConstructor
@RequestMapping("Board")
public class BoardController {
	private static final Logger log =
			LoggerFactory.getLogger(BoardController.class);
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
	
	
	@GetMapping("board_list")
	public void boardList(Model model) {
		log.info("controller boardList : ");
		
		model.addAttribute("boardlist" , service.boardList());
		model.addAttribute("totcount" , service.boardCount());
	
	}
	
}
