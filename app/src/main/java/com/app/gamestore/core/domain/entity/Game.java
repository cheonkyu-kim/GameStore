package com.app.gamestore.core.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static com.app.gamestore.core.common.Require.require;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.AccessLevel;
// import org.hibernate.annotations.GenericGenerator;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import com.app.gamestore.core.domain.exceptions.ErrorCode;
import com.app.gamestore.core.domain.exceptions.game.InvalidGamePrice;

@Entity
@RequiredArgsConstructor
@ToString()
// @AllArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
// @Slf4j
public class Game extends BaseEntitiy {
    // @Id
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(
    //     name = "UUID",
    //     strategy = "org.hibernate.id.UUIDGenerator"
    // )
    // public UUID uid;
    public String title;
    public String price;
    public String description;
    public String companyName;
    public String author;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    public Publisher publisher;

    public static class GameBuilder {
        public GameBuilder title(String title) {
            this.title = title;
            return this;
        }
        public GameBuilder price(String price) {
            long _price = Long.parseLong(price);
            // log.info("{}",_price > 0l);
            require(_price > 0L).ifNot(new InvalidGamePrice(ErrorCode.INVALID_GAME_PRICE, "가격 범위를 초과 했습니다."));
            return this;
        }
    }
}
