package com.jslhrd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.PdsVO;
import com.jslhrd.mapper.PdsMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
@Service
@AllArgsConstructor
public class PdsServiceImpl implements PdsService {
	private static final Logger log = 
            LoggerFactory.getLogger(PdsServiceImpl.class);
	
	@Setter(onMethod_=@Autowired)
	private PdsMapper mapper;
	
	@Override
	public int pdsCount() {
		return mapper.pdsCount();
	}

	/*@Override
	public List<PdsVO> pdsList() {
		return mapper.pdsList();
	}*/
	
	
	//전체목록 page처리 추가
	@Override
	public List<PdsVO> pdsList(PageVO pg){
		return mapper.pdsList(pg);
	}

	@Override
	public int pdsWrite(PdsVO vo) {
		return mapper.pdsWrite(vo);
	}
	
	@Override
	public PdsVO pdsSelect(int idx) {
		return mapper.pdsSelect(idx);
	}
	
	@Override
	public void pdsHits(int idx) {
	}
	@Override
	public int pdsModify(PdsVO vo) {
		return mapper.pdsModify(vo);
	}
	
	//delete 
	@Override
	public int pdsDelete(PdsVO vo){
		return mapper.pdsDelete(vo);
		
	}
}
