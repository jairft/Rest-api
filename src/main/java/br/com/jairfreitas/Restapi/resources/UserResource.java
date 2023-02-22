package br.com.jairfreitas.Restapi.resources;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.domain.dto.UserDto;
import br.com.jairfreitas.Restapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll().
                stream().map(e -> mapper.map(e, UserDto.class)).toList());
    }
    @PostMapping
    public ResponseEntity<UserDto> insertUser(@RequestBody UserDto userDto){
        User user = service.create(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(user, UserDto.class));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(userDto), UserDto.class));

    }
}
