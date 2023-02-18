package br.com.jairfreitas.Restapi.services;

import br.com.jairfreitas.Restapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
