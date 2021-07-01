package com.app.gamestore.core.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Embeddable
public class Email {
    @Column(name = "emailId")
    public String username;
    @Column(name = "emailDomain")
    public String domain;

    @Override
    public String toString() {
        return String.format("%s@%s", username, domain);
    }
}
