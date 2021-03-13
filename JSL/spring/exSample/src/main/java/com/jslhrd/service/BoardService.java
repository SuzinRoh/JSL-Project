package com.jslhrd.service;

import java.util.List;

import com.jslhrd.domain.BoardVO;

public interface BoardService {
	
	
	// all board write counting method
	public int boardCount();
	
	// get all board data 
	public List<BoardVO> boardList();
}
