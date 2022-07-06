package ru.itis.remember.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.remember.models.City;

import java.util.List;

public interface CityRepository extends CrudRepository<City,Long> {
    List<City> findAll();
}
