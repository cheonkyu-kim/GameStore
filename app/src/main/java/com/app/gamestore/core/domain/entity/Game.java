package com.app.gamestore.core.domain.entity;

import java.util.UUID;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// import org.hibernate.annotations.GenericGenerator;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@ToString()
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
}
