package com.app.gamestore.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;

// import java.util.UUID;

// import javax.annotation.Generated;
// import javax.persistence.AttributeOverride;
// import javax.persistence.AttributeOverrides;
// import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.app.gamestore.core.domain.vo.Email;
import com.app.gamestore.core.domain.vo.Name;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@ToString
public class Publisher extends BaseEntitiy {
    public String username;
    public String password;
    @Embedded
    public Name name;
    @Embedded
    public Email email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publisher", orphanRemoval = true)
    public List<Game> games = new ArrayList<>();
}
