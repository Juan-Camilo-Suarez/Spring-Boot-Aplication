package ru.itis.remember.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.remember.models.User;

public interface UserRepository extends CrudRepository <User,Long> {
}
