package edu.spring.ex03.service;

import java.util.List;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;

//보통 dao는 테이블을 하나만 연결하는데
//service는 여러개연결할때 쓰임
public interface BoardService {
	public abstract int create(BoardVO vo);
	public abstract List<BoardVO> read(PageCriteria criteria);
	public abstract BoardVO read(int bno);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	public abstract int getTotalNumsOfRecords();
	
	

}
