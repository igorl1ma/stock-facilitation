package com.stockFacilitation.security.jwtutils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class JwtResponseModel implements Serializable {

    private static final long serialVersionUID = -65680598221794127L;
    private final String token;
}
