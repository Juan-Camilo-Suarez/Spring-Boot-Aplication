package ru.itis.remember.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.remember.models.Republic;

import java.util.List;

public interface RepublicRepository extends CrudRepository<Republic, Long> {
    List<Republic> findAll();
}
