package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeDAO;


public class MyTest extends AbstractTestCase {

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		try {
			BoardDTO boardDTO=noticeDAO.select(1);
			assertNotNull(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = noticeDAO.insert(boardDTO);
			assertEquals(1, result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
