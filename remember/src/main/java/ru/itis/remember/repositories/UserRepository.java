package ru.itis.remember.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.remember.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository <User,Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
}
