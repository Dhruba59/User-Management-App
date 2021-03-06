package com.example.userApp.repository;

import com.example.userApp.model.Child;
import com.example.userApp.model.Parent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChildRepository extends CrudRepository<Child, Integer> {
    public List<Child> findAllByParent(Optional<Parent> parent);
}
