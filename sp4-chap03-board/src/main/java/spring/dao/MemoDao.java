package spring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.domain.MemoVO;

public class MemoDao {
	
	private static Long nextId = 3L;
	
	private Map<Long, MemoVO> memoMap = new HashMap<Long, MemoVO>();
	
	public MemoDao() {
		MemoVO vo1 = new MemoVO(1L, "메모01", "작성자01", "1234", new Date());
		MemoVO vo2 = new MemoVO(2L, "메모02", "작성자02", "1234", new Date());
		MemoVO vo3 = new MemoVO(3L, "메모03", "작성자03", "1234", new Date());
		memoMap.put(vo1.getId(), vo1);
		memoMap.put(vo2.getId(), vo2);
		memoMap.put(vo3.getId(), vo3);
	}
	
	public List<MemoVO> selectAll() {
		return new ArrayList<MemoVO>(memoMap.values());
	}
	
	public MemoVO selectById(Long id) {
		return memoMap.get(id);
	}
	
	public void insert(MemoVO memo) {
		memo.setId(++nextId);
		memoMap.put(memo.getId(), memo);
	}
	
	public void update(MemoVO memo) {
		memoMap.put(memo.getId(), memo);
	}
}
