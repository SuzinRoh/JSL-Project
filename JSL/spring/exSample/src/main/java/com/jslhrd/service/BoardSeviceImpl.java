package com.jslhrd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class BoardSeviceImpl implements BoardService {

	private static final Logger log =
			LoggerFactory.getLogger(BoardSeviceImpl.class);
	
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	
	@Override
	public int boardCount() { return mapper.boardCount(); }


	@Override
	public List<BoardVO> boardList() { return mapper.boardList(); }
	
	
	
	
	
	
}
