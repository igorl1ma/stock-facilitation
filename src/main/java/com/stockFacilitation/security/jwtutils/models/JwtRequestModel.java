package com.stockFacilitation.security.jwtutils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -6635447309328382934L;
    private String username;
    private String password;

}
