package com.lucky.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.lucky.domain.MemberVO;

@Repository
public class MemberDAO {
	
	@Inject
	private DataSource dataSource;
	
	
	//등록 수정 삭제 조회
	public void insertMember(MemberVO vo) throws Exception{
		String sql="insert into tbl_member(id, pwd, name, email,jumin) values(?,?,?,?,?)";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getJumin());
		pstmt.executeUpdate();
		
		con.close();
	}
	
	public List<MemberVO> selectAll() throws Exception{//제네릭 
		//하나의 클래스로 여러가지의 타입을 다룰수 있도록 하는 애가 제네릭 MemberList=멤버VO만 저장 하고 관리한다 X List 모든 타입을 리스트로 관리한다
		MemberVO vo = new MemberVO();
		
		List<MemberVO> list=new ArrayList<>();
		String sql = "select * from tbl_member";
		
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			int i=1;
			vo.setId(rs.getString(i++));
			vo.setPwd(rs.getString(i++));
			vo.setName(rs.getString(i++));
			vo.setEmail(rs.getString(i++));
			vo.setJumin(rs.getString(i++));
			vo.setRegdate(rs.getDate(i++));
			vo.setUpdatedate(rs.getDate(i++));
			list.add(vo);
		}
		con.close();
		return list;
	}
	
	public void deleteMember(String id) throws SQLException{
		String sql = "delete from tbl_member where id = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
		con.close();
		
	}
	
	public void updateMember(MemberVO vo) throws Exception{
		String sql = "update tbl_member set pwd = ?,email=?, updatedate = now() where id= ? ";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getId());
		
		pstmt.executeUpdate();
		
		con.close();
		
		
	}
	
	public MemberVO selectMember(String id) throws SQLException{
		String sql = "select * from tbl_member where id = ? ";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, id);
	    
	    ResultSet rs=pstmt.executeQuery();
	    rs.next();
	    MemberVO vo=new MemberVO();
	    int i=1;
	    vo.setId(rs.getString(i++));
	    vo.setPwd(rs.getString(i++));
	    vo.setName(rs.getString(i++));
	    vo.setEmail(rs.getString(i++));
	    vo.setJumin(rs.getString(i++));
	    vo.setRegdate(rs.getDate(i++));
	    vo.setUpdatedate(rs.getDate(i++));
	    return vo;
	}
}
