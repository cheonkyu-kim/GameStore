package com.app.gamestore.core.domain.entity;

// import java.util.UUID;

// import javax.annotation.Generated;
// import javax.persistence.AttributeOverride;
// import javax.persistence.AttributeOverrides;
// import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

import com.app.gamestore.core.domain.vo.Email;
import com.app.gamestore.core.domain.vo.Name;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@ToString
public class Member extends BaseEntitiy {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // public UUID uid;
    // public String username;
    // public String password;

    @Embedded
    // @AttributeOverrides({
    //         @AttributeOverride(name = "firstName",column = @Column(name = "firstName")),
    //         @AttributeOverride(name = "lastName",column = @Column(name = "lastName"))
    // })
    public Name name;
    @Embedded
    public Email email;
}
