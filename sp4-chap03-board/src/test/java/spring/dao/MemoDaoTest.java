package spring.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.domain.MemoVO;

public class MemoDaoTest {

	ApplicationContext ctx;
	
	private MemoDao memoDao;
	
	@Before
	public void setUp() {
		// GenericXmlApplicationContext -> GXAC 자동완성
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml"); 
		memoDao = ctx.getBean(MemoDao.class);
	}
	
	@After
	public void testUp() {
		((GenericXmlApplicationContext) ctx).close();
	}
	
	// 게시글 목록
//	@Test
	@Ignore
	public void testSellectAll() { 
		List<MemoVO> memoList = memoDao.selectAll();
		System.out.println(memoList);
		assertNotNull(memoList); // 게시글이 존재함
		assertEquals(3, memoList.size()); // 게시글 3개임
	}
	
	// 게시글 조회
//	@Test
	@Ignore
	public void testSelectById() {
		MemoVO findMemo = memoDao.selectById(1L);
		assertNotNull(findMemo); // 게시글이 존재함
		System.out.println(findMemo);
		
		findMemo = memoDao.selectById(100L);
		assertNull(findMemo); // 게시글 없음
	}
	
	// 게시글이 없을때 발생하는 예외 처리
	// expected : 지정된 예외가 발생했을때 테스트를 성공한것으로 판별
//	@Test(expected = NullPointerException.class)
	@Ignore
	public void testSelectById2() {
		MemoVO findMemo = memoDao.selectById(100L);
		System.out.println(findMemo.getId());
	}
	
	// 게시글 삽입
//	@Test
	@Ignore
	public void testInsert() {
		memoDao.insert(new MemoVO(null, "메모04", "글쓴이", "1111", new Date()));
		MemoVO findMemo = memoDao.selectById(4L);
		assertNotNull(findMemo);
		System.out.println(findMemo);
	}
	
	// 게시글 수정
	@Test
//	@Ignore
	public void testupdate() {
		MemoVO findMemo = memoDao.selectById(1L);
		findMemo.setContent("메모01 -- 수정");
		findMemo.setPassword("7878");
		memoDao.update(findMemo);
		
		// 수정 처리 후
		findMemo = memoDao.selectById(1L);
		System.out.println(findMemo);
	}

}
