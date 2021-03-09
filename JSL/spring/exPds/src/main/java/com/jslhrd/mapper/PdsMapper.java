package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.PdsVO;

public interface PdsMapper {
	// 전체 게시물 카운트
	public int pdsCount();
	
	// 전체목록(검색 및 Page 처리 없음)
	public List<PdsVO> pdsList();
	
	// 특정 게시물 검색
	
	// 등록
	public int pdsWrite(PdsVO vo);
	
	//수정처리
	public int pdsModify(PdsVO vo);
	
	
	public PdsVO pdsSelect(int idx);
	//조회수증가
	public void pdsHits(int idx);
}
