package br.com.jairfreitas.Restapi.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
@Getter
@AllArgsConstructor
public class StandardErro {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
