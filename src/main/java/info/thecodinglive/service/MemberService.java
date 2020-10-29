package info.thecodinglive.service;

import org.springframework.stereotype.Service;

import info.thecodinglive.model.LoginVO;
import info.thecodinglive.model.MemberVO;
import info.thecodinglive.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public MemberVO login(LoginVO vo) throws Exception {
		System.out.println("=======>" + vo);
		vo.test();
		return memberRepository.login(vo);
	}
	
//	public void register(MemberVO vo) throws Exception {
//		dao.register(vo);
//	}
}
