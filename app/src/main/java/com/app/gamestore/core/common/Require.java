package com.app.gamestore.core.common;

import java.util.function.Supplier;

import com.app.gamestore.core.domain.exceptions.DomainException;

public class Require {
    public boolean condition;

    Require(boolean conditon) {
        this.condition = condition;
    }

    public static Require require(boolean condition) throws Exception {
        return new Require(condition);
    }

    public void ifNot(DomainException exception) {
        thenThrow(()->exception);
    }

    public void thenThrow(Supplier<DomainException> exception) {
        if(!condition) {
            throw exception.get();
        }
    }
}

