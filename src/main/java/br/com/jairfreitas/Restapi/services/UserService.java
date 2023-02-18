package br.com.jairfreitas.Restapi.services;

import br.com.jairfreitas.Restapi.domain.User;

public interface UserService {

    User findById(Integer id);
}
