package com.simple.basic.service;

import java.util.List;

import com.simple.basic.command.MemoVo;

public interface MemoService {
	
	public boolean insert(MemoVo vo);
	public List<MemoVo> selectAll();
	public MemoVo memoDetail(int mno);
}
