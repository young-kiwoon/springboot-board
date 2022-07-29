package com.simple.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVo;

@Mapper
public interface MemoMapper {

	public boolean insert(MemoVo vo);
	public List<MemoVo> selectAll();
	public MemoVo select(int mno);
}
