package com.simple.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVo;
import com.simple.basic.mapper.MemoMapper;

@Service("memoService")
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoMapper memoMapper;
	
	@Override
	public boolean insert(MemoVo vo) {
		return memoMapper.insert(vo);
	}

	@Override
	public List<MemoVo> selectAll() {
		return memoMapper.selectAll();
	}

	@Override
	public MemoVo memoDetail(int mno) {
		return memoMapper.select(mno);
	}

	
}
