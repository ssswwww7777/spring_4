package com.iu.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTestCase;
import com.iu.util.Pager;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Inject
	private NoticeDAO noticeDAO;
	private Pager pager;
	
	@BeforeClass
	public static void start() {
		System.out.println("Start Test");
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("Finish Test");
	}
	
	@Before
	public void before() {
		System.out.println("Before Test");
	}
	
	@After
	public void after() {
		System.out.println("After Test");
	}
	
	@Test
	public void deleteTest() {
		System.out.println("deleteTest()");
	}
	
	@Test
	public void UpdateTest() {
		System.out.println("UpdateTest()");
	}
	
	@Test
	public void insertTest() {
		System.out.println("insertTest()");
	}

	
	//@Test
	public void test() {
		try {
			List<BoardDTO> ar = noticeDAO.list(pager);
			assertNotEquals(0, ar.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listTest() {
		
		
	}

}
