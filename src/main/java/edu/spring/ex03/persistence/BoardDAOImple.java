package edu.spring.ex03.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;

@Repository // @Component
//- 영속 계층(Persistence Layer)의 DB 관련 기능을 담당
//- Spring Component bean으로 등록함
//- 스프링 프레임워크가 bean을 생성하기 위해서는
//	root-context.xml에 bean으로 등록해야함
//- <context:component-scan ... />
public class BoardDAOImple implements BoardDAO{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex03.BoardMapper";
	
	//MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardVO vo) {
		LOGGER.info("insert호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<BoardVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE+ ".select_all");
	}

	@Override
	public BoardVO select(int bno) {
		LOGGER.info("select(bno) 호출");
		return (BoardVO) sqlSession.selectOne(NAMESPACE + ".select_bno", bno);
	}

	@Override
	public int update(BoardVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete(bno) 호출");
		return sqlSession.delete(NAMESPACE + ".delete_all", bno);
		// TODO 과제2 쿼리 작성하고, 테스트까지
	}

	@Override
	public List<BoardVO> select(PageCriteria c) {
		LOGGER.info("List<BoardVO> select pageCriteria 호출");
		return sqlSession.selectList(NAMESPACE+".PageCriteria" , c);
		// TODO 과제3 쿼리 작성하고, 테스트까지 start: c.getstart() end:c.getend()
	}


	
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNums 호출");
		return sqlSession.selectOne(NAMESPACE + ".select_totalNum");
		// TODO 과제4 쿼리 작성하고, 테스트까지
	}

	
	@Override
	public List<BoardVO> select(String userid) {
		LOGGER.info("select() 호출 : userid = " + userid);
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid", userid);
	}

	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("select() 호출 : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_keyword", keyword);
	}

}
