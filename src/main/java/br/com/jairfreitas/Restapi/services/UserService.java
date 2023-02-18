package br.com.jairfreitas.Restapi.services;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDto userDto);
}
