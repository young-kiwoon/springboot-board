package com.simple.basic.controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import com.simple.basic.command.MemoVo;

public interface MemoController {
	
	public String memoWrite();
	public String memoForm(MemoVo vo, Errors err, Model model);
	public String selectAll(Model model);
	public String detail(int mno, Model model);
}
