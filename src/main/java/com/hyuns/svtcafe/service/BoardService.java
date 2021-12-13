package com.hyuns.svtcafe.service;

import com.hyuns.svtcafe.dto.BoardFormDto;
import com.hyuns.svtcafe.entity.Board;
import com.hyuns.svtcafe.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save(BoardFormDto boardFormDto) {
        return boardRepository.save(boardFormDto.toEntity()).getId();
    }

    @Transactional
    public Board getPost(Long bno){
        return boardRepository.findById(bno).get();
    }

}
