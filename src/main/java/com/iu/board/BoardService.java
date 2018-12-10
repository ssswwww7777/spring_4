package com.iu.board;

import java.util.List;

import com.iu.util.Pager;

public interface BoardService {

	//list
	public List<BoardDTO> list(Pager pager)throws Exception;
	//select
	public BoardDTO select()throws Exception;
	//insert
	public int insert() throws Exception;
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	//delete
	public int delete(int num)throws Exception;
}
