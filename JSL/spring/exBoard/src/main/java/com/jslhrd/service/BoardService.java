package com.jslhrd.service;

import java.util.List;

import com.jslhrd.domain.BoardVO;

public interface BoardService {
		//게시물 전체 카운트
		public int boardCount();
		
		//전체게시물검색
		public List<BoardVO> boardList();
		
		//특정게시물검색
		public BoardVO boardSelect(int idx);
		
		//등록
		public int boardWrite(BoardVO vo);
		
		//수정
		public int boardUpdate(BoardVO vo);
		
		//
		public int boardDelete(BoardVO vo);
		
		//조회수
		public void boardHits(int idx);
}
//controller 호출 >mapper 호출> service