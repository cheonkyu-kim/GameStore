package com.app.gamestore.core.common;

import java.util.function.Supplier;

import com.app.gamestore.core.domain.exceptions.DomainException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Require {
    public boolean condition;

    public Require(boolean _conditon) {
        this.condition = _conditon;
    }

    public static Require require(boolean _condition) {
        return new Require(_condition);
    }

    public void ifNot(DomainException exception) {
        thenThrow(()->exception);
    }

    public void thenThrow(Supplier<DomainException> exception) {
        if(!this.condition) {
            throw exception.get();
        }
    }
}

