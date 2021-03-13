package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.BoardVO;

public interface BoardMapper {
	
	
	// all board write counting method
	public int boardCount();
	
	// get all board data 
	public List<BoardVO> boardList();
	
}
