package edu.spring.ex03.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;
import edu.spring.ex03.persistence.BoardDAO;

@Service // @Component
// 스프링 프레임워크에게 서비스 계층(Service/Business layer)의
// 컴퍼넌트임을 알려주는 어노테이션
public class BoardServiceImple implements BoardService{
   private static final Logger LOGGER =
         LoggerFactory.getLogger(BoardServiceImple.class);

   @Autowired
   private BoardDAO dao;
   
   @Override
   public int create(BoardVO vo) {
      LOGGER.info("create() 호출 : vo = " + vo.toString());
      return dao.insert(vo);
   }

   @Override
   public List<BoardVO> read(PageCriteria criteria) {
      LOGGER.info("read() 호출 : PageCriteria = " + criteria);
      return dao.select(criteria);
   }

   @Override
   public BoardVO read(int bno) {
      LOGGER.info("read() 호출 : bno = " + bno);
      return dao.select(bno);
   }

   @Override
   public int update(BoardVO vo) {
      LOGGER.info("update() 호출 : vo = " + vo.toString());
      return dao.update(vo);
   }

   @Override
   public int delete(int bno) {
      LOGGER.info("delete() 호출 : bno = " + bno);
      return dao.delete(bno);
   }

   @Override
   public int getTotalNumsOfRecords() {
      LOGGER.info("getTotalNumsOfRecords() 호출");
      return dao.getTotalNumsOfRecords();
   }
}