package br.com.jairfreitas.Restapi.services.exceptons;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
