package ru.itis.remember.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.remember.models.City;

public interface CityRepository extends CrudRepository<City,Long> {
}
