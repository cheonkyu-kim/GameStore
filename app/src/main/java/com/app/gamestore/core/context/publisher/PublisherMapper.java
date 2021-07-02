package com.app.gamestore.core.context.publisher;

import java.util.List;

import com.app.gamestore.api.dto.GameDto;
import com.app.gamestore.api.dto.PublisherDto;
import com.app.gamestore.core.domain.entity.Game;
import com.app.gamestore.core.domain.entity.Publisher;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher toEntity(PublisherDto.Result publisherDto);
    Publisher toEntity(PublisherDto.New publisherDto);
    Publisher toEntity(PublisherDto.Edit publisherDto);
    PublisherDto.Result toDto(Publisher publisher);

    List<PublisherDto.Result> toDtoList(List<Publisher> publisher);
}
