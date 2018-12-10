package com.iu.util;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.iu.s4.AbstractTestCase;

public class PagerTests extends AbstractTestCase{

	private static Pager pager;
	
	@BeforeClass
	public static void setData() {
		pager = new Pager();
	}
	
	@Test
	public void test() {
		//assertEquals(1, pager.getCurPage());
		//curPage X      1
		//perBlock X     5
 		//perPage X      10
		//kind X         title
		//search X       ""
		//pager.makeRow();
		//assertEquals(10, pager.getLastRow());
	}

}
