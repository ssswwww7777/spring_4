package com.iu.board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeDTO;
import com.iu.util.DBConnector;
import com.iu.util.Pager;


@Repository
public class QnaDAO implements BoardDAO {
	
	
	@Override
	public int totalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {{
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con  = DBConnector.getConnect();
		String sql ="select*from"
				+ "(select rownum R, N.* from" 
				+ "(select*from qna where "+pager.getKind()+"like ? order by num desc) N"
		        + "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+pager.getSearch()+"%");
		st.setInt(2, pager.getStartRow());
		st.setInt(3, pager.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			ar.add(qnaDTO);
			
		}
		
		DBConnector.disConnect(st, con, rs);
		
		return ar;
	}
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql="select * from qna where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		QnaDTO qnaDTO = new QnaDTO();
		if(rs.next()) {
			qnaDTO =new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
		}
		DBConnector.disConnect(st, con, rs);
		
		return qnaDTO;
	}

	//원본글 작성할때 쓰려고하는 메서드. 답글다는건 따로 만들어야겠다
	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="insert into qna values(qna_seq.nextval,?,?,?,sysdate,qna_seq.currval,0,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//답글작성할때 쓰는 메서드 
public int reply(QnaDTO qnaDTO) throws Exception {
	Connection con = DBConnector.getConnect();
	String sql ="insert into qna values(qna_seq.nextval,?,?,?,sysdate,0,?,?,?)";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, qnaDTO.getTitle());
	st.setString(2, qnaDTO.getWriter());
	st.setString(3, qnaDTO.getContents());
	st.setInt(4, qnaDTO.getRef());
	st.setInt(5, qnaDTO.getStep());
	st.setInt(6, qnaDTO.getDepth());
	int result = st.executeUpdate();
	DBConnector.disConnect(st, con);
    return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql="update qna set title=?,contents=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete qna where num=?;";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

}
