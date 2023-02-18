package br.com.jairfreitas.Restapi.services.impl;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.domain.dto.UserDto;
import br.com.jairfreitas.Restapi.repositories.UserRepository;
import br.com.jairfreitas.Restapi.services.UserService;
import br.com.jairfreitas.Restapi.services.exceptons.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDto userDto) {
        return repository.save(mapper.map(userDto, User.class));
    }


}
