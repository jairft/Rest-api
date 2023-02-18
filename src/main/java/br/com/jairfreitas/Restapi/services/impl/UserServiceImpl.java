package br.com.jairfreitas.Restapi.services.impl;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.repositories.UserRepository;
import br.com.jairfreitas.Restapi.services.UserService;
import br.com.jairfreitas.Restapi.services.exceptons.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }


}
