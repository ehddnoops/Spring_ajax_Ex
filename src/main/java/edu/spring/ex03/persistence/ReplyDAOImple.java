package edu.spring.ex03.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO{
	private static final Logger LOGGER=
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex03.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		LOGGER.info("insert()호출 ");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReplyVO> select(int replyBno) {
		LOGGER.info("select() 호출 : replyBno = ", replyBno);
		return sqlSession.selectList(NAMESPACE+ ".select_all_by_reply_bno", replyBno);
	}

	@Override
	public int update(ReplyVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE+ ".update", vo);
	}

	@Override
	public int delete(int replyNo) {
		LOGGER.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", replyNo);
	}

}
