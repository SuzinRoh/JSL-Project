package com.jslhrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("Main")
public class MainController {
	private static final Logger log = 
			LoggerFactory.getLogger(MainController.class);
	
	
	@GetMapping("index")
	public void MainIndex() {
		log.info("maincontroller ");
	}
}
