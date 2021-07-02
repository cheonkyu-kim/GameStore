package com.app.gamestore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.app.gamestore.api.dto.GameDto;
import com.app.gamestore.api.dto.PublisherDto;
import com.app.gamestore.core.context.game.GameService;
import com.app.gamestore.core.context.publisher.PublisherService;

import java.util.List;
import java.util.Map;
// import java.util.UUID;

// import static java.util.UUID.fromString;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    void signin(@RequestBody PublisherDto.New publisher) {
        log.info("{}", publisher);
        publisherService.signin(publisher);
    }

    @ResponseStatus(CREATED)
    @PostMapping(path="/game/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    void registerNewGame(@PathVariable String uid, @RequestBody GameDto.New game) {
        game.publisher_uid = Long.parseLong(uid);
        log.info("{}", game);
        publisherService.registerNewGame(game);
    }

    // @ResponseStatus(OK)
    // @GetMapping
    // List<GameDto.Result> getGames() {
    //     return publisherService.findGames();
    // }

    // @ResponseStatus(NO_CONTENT)
    // @PatchMapping(path="/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    // void updateGame(@PathVariable String uid, @RequestBody GameDto.Edit game) {
    //     game.uid = Long.parseLong(uid);
    //     publisherService.update(game);
    // }

    // @ResponseStatus(NO_CONTENT)
    // @DeleteMapping(path="/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    // void deleteGame(@PathVariable String uid) {
    //     long _uid = Long.parseLong(uid);
    //     publisherService.delete(_uid);
    // }

    // @ResponseStatus(OK)
    // @GetMapping("/list")
    // public List<GameDto.Result> getPostList(@RequestParam(required = false) Map<String, Object> searchRequest, Pageable pageable) {
    //     // Pageable pageable = PageRequest.of(0, 20);
    //     return publisherService.search(searchRequest, pageable);
    // }

}