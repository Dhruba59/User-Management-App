package com.example.userApp.model;

import com.example.userApp.dto.ParentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Address {
    public Address(ParentDTO parentDTO) {
        street = parentDTO.getStreet();
        city = parentDTO.getCity();
        state = parentDTO.getState();
        zip = parentDTO.getZip();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String city;

    private String state;

    private Integer zip;
}
