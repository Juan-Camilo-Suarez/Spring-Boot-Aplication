package ru.itis.remember.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.remember.models.District;

import java.util.List;

public interface DistrictRepository  extends CrudRepository <District,Long> {
    List<District> findAll();
}
