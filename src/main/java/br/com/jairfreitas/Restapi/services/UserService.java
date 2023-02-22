package br.com.jairfreitas.Restapi.services;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.domain.dto.UserDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDto userDto);

    User update(UserDto userDto);
    void delete(Integer id);
}
