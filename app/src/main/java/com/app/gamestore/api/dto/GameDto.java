package com.app.gamestore.api.dto;

// import java.util.UUID;

import lombok.Data;

public class GameDto {

    @Data
    public static class New {
        public String title;
        public String price;
        public String author;
        public String description;
        public String companyName;
    }

    @Data
    public static class Edit {
        public long uid;
        public String title;
        public String price;
    }

    @Data
    public static class Result {
        public long uid;
        public String title;
        public String price;
    }

}

