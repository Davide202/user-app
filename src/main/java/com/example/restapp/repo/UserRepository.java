package com.example.restapp.repo;


import com.example.restapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface UserRepository extends JpaRepository<User,Long> {

    @RestResource(path = "name",rel = "name")
    List<User> findByFirstName(String name);


}
