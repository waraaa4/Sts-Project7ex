package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {
	
	// 게시물 등록 메소드
	int register(BoardDTO dto);

	// default 키워드: 인터페이스에서 일반 함수를 추가하는 기능
	// DTO를 엔티티로 변환하는 메소드
	default Board dtoToEntity(BoardDTO dto) {
		// 시간 필드는 생략
		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		return entity;
	}
	// entity -> Dto 변환 메소드
	default BoardDTO entityToDTO(Board entity) {
		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		return dto;
	}

}
