package com.example.restapp.repo;

import com.example.restapp.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository  extends JpaRepository<Group,Long> {

    Group findByDescription(String description);
}
