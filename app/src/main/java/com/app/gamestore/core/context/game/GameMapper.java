package com.app.gamestore.core.context.game;

import java.util.List;

import com.app.gamestore.api.dto.GameDto;
import com.app.gamestore.core.domain.entity.Game;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    Game toEntity(GameDto.Result gameDto);
    Game toEntity(GameDto.New gameDto);
    Game toEntity(GameDto.Edit gameDto);
    GameDto.Result toDto(Game game);

    List<GameDto.Result> toDtoList(List<Game> game);
}
