package com.jh.memberFile;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "MemberFileMapper.";
	
	public int setWrite(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite",memberFileDTO);
	}
	
	public MemberFileDTO getSelect(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect",id);
	}
}
