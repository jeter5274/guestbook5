package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	public List<GuestbookVo> getList() {

		List<GuestbookVo> GBList = sqlSession.selectList("guestbook.getList");
		
		return GBList;
	}

	public int insert(GuestbookVo gbVo) {

		int count = sqlSession.insert("guestbook.insert", gbVo);
		//System.out.println("[DAO] insert result : " + count + " complete");
		return count;
	}

	public int delete(GuestbookVo gbVo) {

		int count = sqlSession.delete("guestbook.delete", gbVo);
		//System.out.println("[DAO] delete result : " + count + " complete");
		return count;

	}

}