package com.jslhrd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.mapper.BoardMapper;

import lombok.Setter;


@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger log = 
			LoggerFactory.getLogger(BoardServiceImpl.class);

	@Setter(onMethod_=@Autowired)//== @Inject > 주
	private BoardMapper mapper;
	
	@Override
	public int boardCount() {
		log.info("Service : boardCount() Call ..... ");
		return mapper.boardCount();
	}
	@Override
	public List<BoardVO> boardList(){
		return mapper.boardList();
	}
	@Override
	public BoardVO boardSelect(int idx){
		return mapper.boardSelect(idx);
	}
			
	@Override
	public int boardWrite(BoardVO vo){	
		return mapper.boardWrite(vo);
	}
			
	@Override
	public int boardUpdate(BoardVO vo){
		return mapper.boardUpdate(vo);
	}
			
	@Override
	public int boardDelete(BoardVO vo){
		return mapper.boardDelete(vo);
	}
	
	@Override
	public void boardHits(int idx) {
		mapper.boardHits(idx);
	}

}
