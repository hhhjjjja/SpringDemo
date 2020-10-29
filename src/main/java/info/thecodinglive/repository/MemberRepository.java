package info.thecodinglive.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.LoginVO;
import info.thecodinglive.model.MemberVO;

@Repository
public class MemberRepository{
	static final String MAPPER_NAME_SPACE="mappers.memberMapper.";
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public MemberVO login(LoginVO vo){
		System.out.println("*****rep login*****");
		return sql.selectOne(MAPPER_NAME_SPACE+"login", vo);
	}
	
	public void register(MemberVO vo) {
		sql.insert(MAPPER_NAME_SPACE+"register", vo);
	}
}
