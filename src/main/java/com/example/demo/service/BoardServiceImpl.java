package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

//자식 클래스들 중 서비스로 지정
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository repository; // 리파지토리를 빈으로 주입

	@Override
	public int register(BoardDTO dto) {
		// 전달받은 DTO를 엔티티로 전환
		Board entity = dtoToEntity(dto);
		
		// 엔티티를 테이블에 저장
		repository.save(entity);

		// 저장 후 게시물의 번호를 반환
		return entity.getNo();
	}

}
