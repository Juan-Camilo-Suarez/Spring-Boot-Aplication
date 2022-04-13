package com.example.first_aplication.repository;

import com.example.first_aplication.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
