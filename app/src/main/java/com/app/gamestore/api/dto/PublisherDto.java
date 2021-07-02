package com.app.gamestore.api.dto;

import com.app.gamestore.core.domain.vo.Email;
import com.app.gamestore.core.domain.vo.Name;

// import java.util.UUID;

import lombok.Data;

public class PublisherDto {

    @Data
    public static class New {
        public String username;
        public String password;
        public Name name;
        public Email email;
    }

    @Data
    public static class Edit {
        public long uid;
        public String password;
        public Name name;
        public Email email;
    }

    @Data
    public static class Result {
        public long uid;
        public Name name;
    }

}

