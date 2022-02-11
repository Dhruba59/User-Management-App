package com.example.demo.model;

import com.example.demo.dto.ParentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Parent {
    public Parent(ParentDTO parentDTO, Address address) {
        firstName = parentDTO.getFirstName();
        lastName = parentDTO.getLastName();
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Address address;

//    @ManyToOne
//    private Parent parent;
}
