package com.ict4dev.benildo.userapi.controller;

import com.ict4dev.benildo.userapi.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {

        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setNuit("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(LocalDateTime.now().toString());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setNuit("456");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(LocalDateTime.now().toString());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setNuit("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(LocalDateTime.now().toString());


        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{nuit}")
    public UserDTO getUsersFiltro(@PathVariable String nuit) {
        for (UserDTO userFilter: usuarios) {
            if (userFilter.getNuit().equals(nuit)) {
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(LocalDateTime.now().toString());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/user/{nuit}")
    public boolean remover(@PathVariable String nuit) {
        for (UserDTO userFilter: usuarios) {
            if (userFilter.getNuit().equals(nuit)) {
                usuarios.remove(userFilter);
                return true;
            }
        }
        return false;
    }

}
