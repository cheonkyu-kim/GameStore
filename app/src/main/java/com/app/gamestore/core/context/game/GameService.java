package com.app.gamestore.core.context.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.gamestore.core.domain.entity.Game;
import com.app.gamestore.core.domain.spec.GameSpec;
import com.app.gamestore.core.domain.spec.GameSpec.SearchKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import com.app.gamestore.api.dto.GameDto;

@Slf4j
@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepository gameRepositoy;

    public GameDto.Result findOne() {
        return null;
    }

    @Transactional(readOnly = true)
    public List<GameDto.Result> findGames() {
        List<Game> gameList = gameRepositoy.findAll();
        return GameMapper.INSTANCE.toDtoList(gameList);
    }

    public Game register(GameDto.New newGame) {
        log.info("input DTO {}", newGame);
        Game game = GameMapper.INSTANCE.toEntity(newGame);
        return gameRepositoy.save(game);
    }

    public void update(GameDto.Edit editGame) {
        log.info("input DTO {}", editGame);
        Game input = GameMapper.INSTANCE.toEntity(editGame);
        Optional<Game> game = gameRepositoy.findByUid(input.uid);
        // log.info("{}", game);
        game.ifPresent(item ->{
            item.title = editGame.title;
            item.price = editGame.price;
            Game updated = gameRepositoy.save(item);
            log.info("{}", updated);
        });
    }

    public void delete(long uid) {
        Optional<Game> game = gameRepositoy.findByUid(uid);
        // log.info("{}", game);
        game.ifPresent(item ->{
            item.isLive = false;
            Game updated = gameRepositoy.save(item);
            log.info("{}", updated);
        });
    }

    @Transactional(readOnly = true)
    public List<GameDto.Result> search(Map<String, Object> searchRequest, Pageable pageable) {
        // Pageable pageable = PageRequest.of(0, 20);
        Map<SearchKey, Object> searchKeys = new HashMap<>();
        for (String key : searchRequest.keySet()) {
            searchKeys.put(SearchKey.valueOf(key.toUpperCase()), searchRequest.get(key));
        }
        
        Page<Game> pages =  searchKeys.isEmpty()
                ? gameRepositoy.findAll(pageable)
                : gameRepositoy.findAll(GameSpec.searchWith(searchKeys), pageable);

        log.info("page : {}", pages.getContent());
        return GameMapper.INSTANCE.toDtoList(pages.getContent());
    }
}
