package com.example.demo.repository;

import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChildRepository extends CrudRepository<Child, Integer> {
    public List<Child> findAllByParent(Optional<Parent> parent);
}
