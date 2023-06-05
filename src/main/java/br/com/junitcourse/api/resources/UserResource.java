package br.com.junitcourse.api.resources;

import br.com.junitcourse.api.domain.User;
import br.com.junitcourse.api.domain.dto.UserDTO;
import br.com.junitcourse.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){


        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }
}
