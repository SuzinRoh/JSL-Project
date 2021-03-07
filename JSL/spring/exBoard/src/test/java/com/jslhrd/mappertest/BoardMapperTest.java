package com.jslhrd.mappertest;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;
@Log4j

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	@Inject
	private BoardMapper mapper;
	/*
	@Test
	public void BoardCount() {
		int count =mapper.boardCount();
		log.info(mapper.boardCount());
	}*/
	
/*	@Test
	public void BoardList() {
		//log.info(mapper.boardList());
		mapper.boardList().forEach(board->log.info(board));
	}*/
	
/*	@Test
	public void boardSelect() {
		BoardVO vo = mapper.boardSelect(3);
		log.info("내용:"+vo);
	}*/
	
	/*@Test
	public void boardWrite() {
		BoardVO vo = new BoardVO();
		vo.setName("KIMURA");
		vo.setEmail("mura@naver");
		vo.setPass("1234");
		vo.setSubject("hi");
		vo.setContents("hello");
		
		log.info("등록처리 : " + mapper.boardWrite(vo));
	}*/
	/*
	@Test 
	public void boardUpdate() {
		BoardVO vo = new BoardVO();
		vo.setIdx(8);
		vo.setSubject("hi");
		vo.setContents("hello");
		
		log.info("edit : " + mapper.boardUpdate(vo));
	}
	
	@Test
	public void boardDelete() {
		BoardVO vo = new BoardVO();
		
		log.info("edit : " + mapper.boardDelete(2));
	}*/
	
}
