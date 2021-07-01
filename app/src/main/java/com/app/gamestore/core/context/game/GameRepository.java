package com.app.gamestore.core.context.game;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.app.gamestore.core.domain.entity.Game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface GameRepository extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {
    Optional<Game> findByUid(long uid);
    Optional<Game> findByPrice(String price);
    Page<Game> findAll(Specification<Game> spec, Pageable pageable);
}
