package br.com.jairfreitas.Restapi.services.exceptons;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
