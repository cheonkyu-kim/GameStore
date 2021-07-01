package com.app.gamestore.core.domain.exceptions.game;

import com.app.gamestore.core.domain.exceptions.DomainException;
import com.app.gamestore.core.domain.exceptions.ErrorCode;

public class InvalidGamePrice extends DomainException {
    InvalidGamePrice(ErrorCode code, String message) {
        super(code, message);
    }
}
