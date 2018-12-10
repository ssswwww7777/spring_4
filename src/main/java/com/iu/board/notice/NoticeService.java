package com.iu.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.Pager;


@Service
public class NoticeService implements BoardService{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	
	
	public BoardDTO select(int num) throws Exception{
		return noticeDAO.select(num);
	}
	
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		
		return noticeDAO.list(pager);
	}
	
	//여기서는 연결만 하는거임
	public int insert (BoardDTO boardDTO)throws Exception{
		return noticeDAO.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO)throws Exception{
		return noticeDAO.update(boardDTO);		
		
	}
	
	public int delete(int num)throws Exception{
		return noticeDAO.delete(num);
	}

	@Override
	public BoardDTO select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*@Inject
	private NoticeDAO noticeDAO;

	
	public static void main(String[] args) {
		NoticeService noticeService = new NoticeService();
		noticeService.select(1);
	}
	
	//select
	public void select(int num) {
		try {
			BoardDTO boardDTO = noticeDAO.select(num);
			System.out.println(boardDTO.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
