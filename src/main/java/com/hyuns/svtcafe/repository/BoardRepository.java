package com.hyuns.svtcafe.repository;

import com.hyuns.svtcafe.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
