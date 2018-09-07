package com.example.spring02.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.board.dto.BoardDTO;
import com.example.spring02.service.board.BoardService;

@Controller
@RequestMapping("board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception{
		List<BoardDTO> list=boardService.listAll(); //게시물 목록
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", list.size());
		mav.setViewName("board/list"); //포워딩할 뷰의 이름
		mav.addObject("map", map); //ModelAndView에 map을 저장
		return mav;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}

}
