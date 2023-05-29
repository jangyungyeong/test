package spring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemoDao;
import spring.domain.MemoVO;
import spring.domain.dto.MemoDTO;
import spring.exception.PasswordNotMatchingException;

public class MemoServiceTest {

	ApplicationContext ctx;
	
	private MemoService memoService;
	private MemoDao memoDao;
	
	@Before
	public void setUp() {
		// GenericXmlApplicationContext -> GXAC 자동완성
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml"); 
		memoService = ctx.getBean(MemoService.class);
		memoDao = ctx.getBean(MemoDao.class);
	}
	
	@After
	public void testUp() {
		((GenericXmlApplicationContext) ctx).close();
	}
	
	@Test
	public void testInsert() {
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setContent("메모00000000000000000");
		memoDTO.setWriter("관리자");
		memoDTO.setPassword("1111");
		memoDTO.setConfirmPassword("1111");
		memoService.register(memoDTO);
		
		MemoVO findVO = memoDao.selectById(4L);
		assertNotNull(findVO);
		System.out.println(findVO);
	}
	
	@Test(expected = PasswordNotMatchingException.class)
	public void testInsert2() {
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setContent("메모00000000000000000");
		memoDTO.setWriter("관리자");
		memoDTO.setPassword("1111");
		memoDTO.setConfirmPassword("1234");
		memoService.register(memoDTO);
	}

	@Test
	public void testModify() {
		MemoDTO dto = new MemoDTO();
		dto.setContent("1번글 수정합니다.!!");
		memoService.modify(1L, "1234", dto);
		
		MemoVO findVO = memoDao.selectById(1L);
		assertEquals(dto.getContent(), findVO.getContent());
		System.out.println(findVO);
	}
}
