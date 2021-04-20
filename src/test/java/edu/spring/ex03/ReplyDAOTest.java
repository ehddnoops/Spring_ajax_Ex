package edu.spring.ex03;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReplyDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void testDAO() {
//		testInsert();
//		testSelect();
//		testUpdate();
		testDelete();
	}






	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, 1, "test2", "test2", null);
		int result = dao.insert(vo);
		LOGGER.info(result + "행 삽입");
	}//end testInsert()
	
	private void testSelect() {
		List<ReplyVO> list = dao.select(1);
		LOGGER.info(list.size()+"");
		for(ReplyVO vo : list) {
			LOGGER.info(vo.toString());
		}//end for		
	}//end testSelect()
	
	private void testUpdate() {
		ReplyVO vo = new ReplyVO(2, 1, "change", "수정", null);
		int result = dao.update(vo);
		LOGGER.info(result + "행 변경");
		
	}
	private void testDelete() {
		int result = dao.delete(2);
		LOGGER.info(result + "행 삭제");
		
	}
}











