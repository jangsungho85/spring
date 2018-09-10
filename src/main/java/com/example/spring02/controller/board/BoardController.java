package com.example.spring02.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.board.dto.BoardDTO;
import com.example.spring02.service.board.BoardService;

@Controller //controller bean
@RequestMapping("board/*") //공통적인 url pattern
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("list.do") //세부적인 url pattern
	public ModelAndView list() throws Exception{
		List<BoardDTO> list=boardService.listAll(); //게시물 목록
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); //map에 자료 저장
		map.put("count", list.size());
		mav.setViewName("board/list"); //포워딩할 뷰의 이름
		mav.addObject("map", map); //ModelAndView에 map을 저장
		return mav; //board/list.jsp로 이동
	}//list()
	
	@RequestMapping("write.do")
	public String write() {
		//글쓰기 폼 페이지로 이동
		return "board/write";
	}//write()
	
	// write.jsp에서 입력한 내용들이 BoardDTO에 저장됨	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto
			, HttpSession session)
					throws Exception {
		// 이름이 없기때문에 대신 세션에서 사용자아이디를 가져옴
		String writer=(String)session.getAttribute("userid");
		dto.setWriter(writer); 
		//레코드 저장
		boardService.create(dto);//F4
		//게시물 목록으로 이동
		return "redirect:/board/list.do";
	}//insert()
	
}//end class
