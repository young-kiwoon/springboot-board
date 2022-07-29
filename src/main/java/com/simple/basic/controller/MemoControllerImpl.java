package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemoVo;
import com.simple.basic.service.MemoService;

@Controller("memoController")
@RequestMapping("/memo")
public class MemoControllerImpl implements MemoController {

	@Autowired
	MemoService memoService;
	
	@Override
	@GetMapping("/memoWrite")
	public String memoWrite() {
		return "memo/memoWrite";
	}
	
	@Override
	@PostMapping("/memoForm")
	public String memoForm(@Valid MemoVo vo, Errors err, Model model) {
		if(err.hasErrors()) {
			List<FieldError> list = err.getFieldErrors();
			for (FieldError fieldError : list) {
				fieldError.getField();
				model.addAttribute("valid_"+ fieldError.getField(), fieldError.getDefaultMessage());
			}
			model.addAttribute("vo", vo);
			return "memo/memoWrite";
		}
		memoService.insert(vo);
		
		return "redirect:/memo/memoList";
	}

	@Override
	@GetMapping("/memoList")
	public String selectAll(Model model) {
	
		List<MemoVo> list = memoService.selectAll();
		model.addAttribute("list", list);
		return "memo/memoList";
	}

	@Override
	@GetMapping("/memoDetail")
	public String detail(@RequestParam("mno") int mno, Model model) {
		
		MemoVo vo = memoService.memoDetail(mno);
		model.addAttribute("vo", vo);
		return "memo/memoDetail";
	}
	
}
