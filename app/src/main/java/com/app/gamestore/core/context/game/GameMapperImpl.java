package com.app.gamestore.core.context.game;

import java.util.List;

import javax.annotation.Generated;

import com.app.gamestore.api.dto.GameDto;
import com.app.gamestore.core.domain.entity.Game;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Generated(
    value="org.mapstruct.ap.MappingProcessor"
)
// @Component
@Mapper
public class GameMapperImpl implements GameMapper {
    @Override
    public Game toEntity(GameDto.New newGame) {
        if ( newGame == null ) {
            return null;
        }
        Game game = Game.builder()
            .title(newGame.title)
            .price(newGame.price)
            .build();

        return game;
    }

    @Override
    public Game toEntity(GameDto.Edit newGame) {
        if ( newGame == null ) {
            return null;
        }
        Game game = Game.builder()
            .title(newGame.title)
            .price(newGame.price)
            .build();

        return game;
    }

    @Override
    public Game toEntity(GameDto.Result newGame) {
        if ( newGame == null ) {
            return null;
        }
        Game game = Game.builder()
            .title(newGame.title)
            .price(newGame.price)
            .build();

        return game;
    }

    @Override
    public GameDto.Result toDto(Game game) {
        GameDto.Result result = new GameDto.Result();
        result.title = game.title;
        result.price = game.price;
        return result;
    }

    @Override
    public List<GameDto.Result> toDtoList(List<Game> game) {
        return null;
    }
}
