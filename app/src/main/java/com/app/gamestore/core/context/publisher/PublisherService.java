package com.app.gamestore.core.context.publisher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.gamestore.core.context.game.GameMapper;
import com.app.gamestore.core.context.game.GameRepository;
import com.app.gamestore.core.context.game.GameService;
import com.app.gamestore.core.domain.entity.Game;
import com.app.gamestore.core.domain.entity.Publisher;
import com.app.gamestore.core.domain.spec.GameSpec;
import com.app.gamestore.core.domain.spec.GameSpec.SearchKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import com.app.gamestore.api.dto.GameDto;
import com.app.gamestore.api.dto.PublisherDto;

@Slf4j
@Service
@Transactional
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private GameService gameService;

    // 회원가입
    public Publisher signin(PublisherDto.New newPublisher) {
        log.info("input DTO {}", newPublisher);
        Publisher publisher = PublisherMapper.INSTANCE.toEntity(newPublisher);
        return publisherRepository.save(publisher);
    }

    // 회원탈퇴
    public void signout(long uid) {
        Optional<Publisher> publsiher = publisherRepository.findByUid(uid);
        // log.info("{}", game);
        publsiher.ifPresent(item ->{
            item.isLive = false;
            Publisher updated = publisherRepository.save(item);
            log.info("{}", updated);
        });
    }

    // 게임등록
    public Game registerNewGame(GameDto.New newGame) {
        log.info("input DTO {}", newGame);
        // Game game = GameMapper.INSTANCE.toEntity(newGame);
        // log.info("input newGame {}", newGame);
        return gameService.register(newGame);
    }

}
