package spring.service;

import java.util.Date;

import spring.dao.MemoDao;
import spring.domain.MemoVO;
import spring.domain.dto.MemoDTO;
import spring.exception.MemoNotFoundException;
import spring.exception.PasswordNotMatchingException;

public class MemoService { 
	
	private MemoDao memoDao;
	
	public MemoService(MemoDao memoDao) {
		this.memoDao = memoDao;
	}
	
	public void register(MemoDTO memoDTO) {
		// 비밀번호와 확인비밀번호의 일치 여부
		if (!memoDTO.isPasswordMatching()) { // 비밀번호와 확인비밀번호가 불일치할때 예외를 던진다
			// spring.exception 패키지 클릭후 ctrl+c
			// 던질예외에 커서두고 ctrl+1 -> Create class
			// package칸에 ctrl+v
			throw new PasswordNotMatchingException("비밀번호와 비밀번호 확인이 일치하지 않음");
		}
		MemoVO vo = new MemoVO(memoDTO.getContent(), memoDTO.getWriter(), memoDTO.getPassword(), new Date());
		memoDao.insert(vo);
	}
	
	public void modify(Long id, String pwd, MemoDTO memoDTO) {
		// 게시글이 없는 경우
		MemoVO selectVO = memoDao.selectById(id);
		if (selectVO == null) {
			throw new MemoNotFoundException("게시글이 존재하지 않습니다.");
		}
		// 비밀번호 일치 여부
		if (!selectVO.isMatchingPassword(pwd)) {
			throw new PasswordNotMatchingException("비밀번호가 맞지 않습니다.");
		}
		
		// 수정 처리
		selectVO.setContent(memoDTO.getContent());
		memoDao.update(selectVO);
	}
}
