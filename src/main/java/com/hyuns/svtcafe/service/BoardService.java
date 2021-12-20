package com.hyuns.svtcafe.service;

import com.hyuns.svtcafe.dto.BoardFormDto;
import com.hyuns.svtcafe.dto.BoardModifyDto;
import com.hyuns.svtcafe.entity.Board;
import com.hyuns.svtcafe.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final PasswordEncoder passwordEncoder;

    public Long save(BoardFormDto boardFormDto) {
        return boardRepository.save(boardFormDto.toEntity(passwordEncoder)).getId();
    }

    @Transactional
    public Board getPost(Long bno){
        return boardRepository.findById(bno).get();
    }

    @Transactional
    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public Long updatePost(BoardFormDto boardFormDto, Long id){
        Board post = boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        post.updatePost(boardFormDto);

        return post.getId();

    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }


    @Transactional
    public boolean checkPassword(BoardModifyDto boardModifyDto){
        Board findBoard = boardRepository.findById(boardModifyDto.getBno()).get();
        if (!passwordEncoder.matches(boardModifyDto.getPassword(), findBoard.getPassword())) {
            return true;
        }
        return false;
    }

}
