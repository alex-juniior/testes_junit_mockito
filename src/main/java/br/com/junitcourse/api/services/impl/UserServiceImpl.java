package br.com.junitcourse.api.services.impl;

import br.com.junitcourse.api.domain.User;

import br.com.junitcourse.api.repositories.UserRepository;
import br.com.junitcourse.api.services.UserService;
import br.com.junitcourse.api.services.exceptions.ObjectNotFoundException;
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
        return obj.orElseThrow( ()-> new ObjectNotFoundException("Objeto não encontrada"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
