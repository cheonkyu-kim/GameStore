package com.app.gamestore.core.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.RequiredArgsConstructor;

@Embeddable
@RequiredArgsConstructor
public class Name {
    @Column(name="firstName")
    public String firstName;
    @Column(name="lastName")
    public String lastName;

    @Override
    public String toString() {
        return String.format("%s%s", firstName, lastName);
    }
}
