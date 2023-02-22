package br.com.jairfreitas.Restapi.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
}
