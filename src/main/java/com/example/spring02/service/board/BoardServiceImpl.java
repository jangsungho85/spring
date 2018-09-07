package com.example.spring02.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.board.dao.BoardDAO;
import com.example.spring02.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDao;

	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttach(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(String fullName, int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		
		return boardDao.listAll();
	}

	@Override
	public void increateViewcnt(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int countArticle() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
