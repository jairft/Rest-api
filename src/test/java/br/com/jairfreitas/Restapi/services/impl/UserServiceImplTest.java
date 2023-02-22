package br.com.jairfreitas.Restapi.services.impl;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.domain.dto.UserDto;
import br.com.jairfreitas.Restapi.repositories.UserRepository;
import br.com.jairfreitas.Restapi.services.exceptons.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID = 1;
    public static final String NAME = "jair";
    public static final String EMAIL = "jair@outlook.com";
    public static final String PASSWORD = "123";
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDto userDto;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();

    }

    @Test
    void quandoFizerBuscaPeloIdMeRetorneUmaInstanciaDeUser() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        Assertions.assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void quandoBuscarPeloIdMeRetornarUmaExcecao(){
        when(repository.findById(anyInt())).thenThrow(new ResourceNotFoundException("Recurso não encontrado"));

        try {
            service.findById(ID);
        }catch (Exception ex){
            assertEquals(ResourceNotFoundException.class, ex.getClass());
            assertEquals("Recurso não encontrado", ex.getMessage());
        }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDto(1, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(1, NAME, EMAIL, PASSWORD));
    }
}