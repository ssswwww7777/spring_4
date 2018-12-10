package com.iu.board.qna;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTestCase;

public class QnaDAOTest extends AbstractTestCase{

	@Inject
	private QnaDAO qnaDAO;
	private QnaDTO qnaDTO;
	
	//@Test
	public void replyTest()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("rt1");
		qnaDTO.setWriter("rw1");
		qnaDTO.setContents("rc1");
		qnaDTO.setRef(2);
		qnaDTO.setStep(1);
		qnaDTO.setDepth(1);
		int result = qnaDAO.reply(qnaDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void insertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("t2");
		boardDTO.setWriter("w2");
		boardDTO.setContents("c2");
		int result = qnaDAO.insert(boardDTO);
		assertEquals(1, result);
	}

}
